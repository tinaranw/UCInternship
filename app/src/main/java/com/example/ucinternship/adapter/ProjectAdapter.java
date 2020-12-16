package com.example.ucinternship.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Project;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    private Context context;
    private List<Project> projectList;


    public ProjectAdapter(Context context) {
        this.context = context;
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
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProjectViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title, spv, duration, status;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon_card_img);
            title = itemView.findViewById(R.id.task_title_txt);
            spv = itemView.findViewById(R.id.status_task_txt);
            duration = itemView.findViewById(R.id.duration_card_txt);
            status = itemView.findViewById(R.id.status_card_txt);
        }
    }
}