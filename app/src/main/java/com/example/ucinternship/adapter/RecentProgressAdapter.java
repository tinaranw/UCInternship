package com.example.ucinternship.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ucinternship.R;

public class RecentProgressAdapter extends RecyclerView.Adapter<RecentProgressAdapter.RecentProgressViewHolder>{

    private Context context;

    public RecentProgressAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecentProgressAdapter.RecentProgressViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_student_adapter, viewGroup, false);
        return new RecentProgressAdapter.RecentProgressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentProgressAdapter.RecentProgressViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RecentProgressViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView project,task;

        public RecentProgressViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.rpprojecticon_img);
            project = itemView.findViewById(R.id.rpprojectname_txt);
            task = itemView.findViewById(R.id.rpprogressname_txt);
        }
    }
}
