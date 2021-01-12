package com.example.ucinternship.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> implements Filterable {

    private Context context;
    private List<Project> projectList;
    private List<Project> projectListFull;

    public ProjectAdapter(Context context) {
        this.context = context;
    }

    public void setProjectList(List<Project> projectList){
        this.projectList = projectList;
        projectListFull = new ArrayList<>(projectList);
//        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProjectAdapter.ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_project_adapter, viewGroup, false);
        return new ProjectAdapter.ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.ProjectViewHolder holder, int i) {
        Project p = projectList.get(i);
        Log.d("project_name", p.getProject_name());
        holder.title.setText(p.getProject_name());
        holder.duration.setText(p.getProject_deadline());
        holder.spv.setText(p.getProject_spv());
        if(p.getProject_status().equalsIgnoreCase("0")){
            holder.status.setText("Available");
        } else if(p.getProject_status().equalsIgnoreCase("1")){
            holder.status.setText("Ongoing");
        } else if(p.getProject_status().equalsIgnoreCase("2")){
            holder.status.setText("Completed");
        } else if(p.getProject_status().equalsIgnoreCase("3")){
            holder.status.setText("Suspended");
        }
        if(p.getProject_category().equalsIgnoreCase("0")){
            holder.icon.setImageResource(R.drawable.ic_event);
        } else if(p.getProject_category().equalsIgnoreCase("1")){
            holder.icon.setImageResource(R.drawable.ic_material);
        } else if(p.getProject_category().equalsIgnoreCase("2")){
            holder.icon.setImageResource(R.drawable.ic_others);
        }
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    @Override
    public Filter getFilter() {
        return projectFilter;
    }

    private Filter projectFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Project> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(projectListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                //foreach
                for (Project project : projectListFull){
                    if (project.getProject_name().toLowerCase().contains(filterPattern)){
                        filteredList.add(project);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            projectList.clear();
            projectList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

    public class ProjectViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title, spv, duration, status;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon_card_img);
            title = itemView.findViewById(R.id.title_card_txt);
            spv = itemView.findViewById(R.id.spv_card_txt);
            duration = itemView.findViewById(R.id.duration_card_txt);
            status = itemView.findViewById(R.id.status_card_txt);
        }
    }
}