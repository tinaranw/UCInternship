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

import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.local.Student;
import com.example.ucinternship.model.local.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private Context context;
    private List<Task> taskList;

    public TaskAdapter(Context context) {
        this.context = context;
    }

    public void setTaskList(List<Task> taskList){
        this.taskList = taskList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_task_adapter, viewGroup, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int i) {
        Task t = taskList.get(i);
        holder.title.setText(t.getTask_name());
        holder.desc.setText(t.getTask_description());
        if(t.getTask_approved().equalsIgnoreCase("0")){
            holder.status.setText("Ongoing");
        } else if(t.getTask_approved().equalsIgnoreCase("1")){
            holder.status.setText("Completed");
        }
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView title, desc, status;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.task_title_txt);
            desc = itemView.findViewById(R.id.task_desc_txt);
            status = itemView.findViewById(R.id.status_task_txt);
        }
    }
}