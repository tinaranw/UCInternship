package com.example.ucinternship.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.ui.DetailTaskFragmentDirections;

import java.util.List;

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.ProgressViewHolder> {


    private Context context;
    private List<Progress> progressList;

    public ProgressAdapter(Context context) {
        this.context = context;
    }

    public void setProgressList(List<Progress> progressList){
        this.progressList = progressList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProgressAdapter.ProgressViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.progress_adapter, viewGroup, false);
        return new ProgressAdapter.ProgressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgressAdapter.ProgressViewHolder holder, int i) {
        Progress p = progressList.get(i);
        holder.desc.setText(p.getProgress_description());
        if(p.getProgress_approved().equalsIgnoreCase("0")){
            holder.status.setText("Pending");
        } else if(p.getProgress_approved().equalsIgnoreCase("1")){
            holder.status.setText("Approved");
        } else if(p.getProgress_approved().equalsIgnoreCase("2")){
            holder.status.setText("Declined");
        }

        holder.itemView.setOnClickListener(view -> {
            Log.d("progressID", "progress adapter - "+p.getProgress_id());
            NavDirections action = DetailTaskFragmentDirections.actionDetailTaskFragmentToProgressFragment(p);
            Navigation.findNavController(view).navigate(action);
        });
    }

    @Override
    public int getItemCount() {
        return progressList.size();
    }

    public class ProgressViewHolder extends RecyclerView.ViewHolder {

        TextView desc, status;

        public ProgressViewHolder(@NonNull View itemView) {
            super(itemView);
            desc = itemView.findViewById(R.id.progress_desc_txt);
            status = itemView.findViewById(R.id.progress_status_txt);
        }
    }
}
