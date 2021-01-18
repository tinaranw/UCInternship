package com.example.ucinternship.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.local.ProjectUser;
import com.example.ucinternship.model.local.Student;
import com.example.ucinternship.ui.DetailProjectFragment;
import com.example.ucinternship.ui.MainActivity;
import com.example.ucinternship.ui.viewmodel.ProfileViewModel;
import com.example.ucinternship.ui.viewmodel.ProjectDetailViewModel;
import com.example.ucinternship.utils.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private Context context;
    private List<ProjectUser> studentList;
    int count;
    private ProjectDetailViewModel projectDetailViewModel;
    private SharedPreferenceHelper helper;

    public StudentAdapter(Context context) {
        this.context = context;
    }

    public void setStudentList(List<ProjectUser> studentList) {
        this.studentList = studentList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentAdapter.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_student_adapter, viewGroup, false);
        helper = SharedPreferenceHelper.getInstance(context);
        projectDetailViewModel = ViewModelProviders.of((FragmentActivity) context).get(ProjectDetailViewModel.class);
        projectDetailViewModel.init(helper.getAccessToken());
        return new StudentAdapter.StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentViewHolder holder, int i) {
        ProjectUser projectUser = studentList.get(i);
        count = 0;
        if (projectUser.getStatus().equals("0")) {
//            projectDetailViewModel.acceptStudent(projectUser.getUser().getUser_id(), projectUser.getProject_id());
            count++;
            holder.name.setText(projectUser.getUser().getUser_name());
            holder.accept.setOnClickListener(view -> {
                Log.d("projectid+userid", "student adapter - "+projectUser.getProject_id()+projectUser.getUser_id());
                        projectDetailViewModel.acceptStudent(projectUser.getUser_id(), projectUser.getProject_id()).observe((LifecycleOwner) context, response -> {
                            if (response != null) {
                                Toast.makeText(context, "Student Accepted.", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Failed to Accept Student.", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
            );
            holder.cancel.setOnClickListener(view ->
                    projectDetailViewModel.declineStudent(projectUser.getUser_id(), projectUser.getProject_id()).observe((LifecycleOwner) context, response -> {
                        if (response != null) {
                            Toast.makeText(context, "Student Declined.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Failed to Decline Student.", Toast.LENGTH_SHORT).show();
                        }
                    })
            );
        }

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        ImageView image, cancel;
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