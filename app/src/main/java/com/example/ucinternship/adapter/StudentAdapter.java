package com.example.ucinternship.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.local.ProjectUser;
import com.example.ucinternship.model.local.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private Context context;
    private List<ProjectUser> studentList;


    public StudentAdapter(Context context) {
        this.context = context;
    }

    public void setStudentList(List<ProjectUser> studentList){
        this.studentList = studentList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_student_adapter, viewGroup, false);
        return new StudentAdapter.StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int i) {
        ProjectUser projectUser = studentList.get(i);
        holder.name.setText(projectUser.getUser().getUser_name());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        ImageView image,cancel;
        TextView name;
        Button accept;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.profile_pic_student);
            cancel = itemView.findViewById(R.id.cancel_btn);
            name = itemView.findViewById(R.id.stud_name_txt);
            accept = itemView.findViewById(R.id.accept_btn);
        }
    }
}