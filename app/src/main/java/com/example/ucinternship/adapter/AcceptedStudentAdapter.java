package com.example.ucinternship.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ucinternship.R;
import com.example.ucinternship.model.local.ProjectUser;

import java.util.List;

public class AcceptedStudentAdapter extends RecyclerView.Adapter<AcceptedStudentAdapter.AcceptedStudentViewHolder> {

    private Context context;
    private List<ProjectUser> acceptedStudentList;
    int count;

    public AcceptedStudentAdapter(Context context) {
        this.context = context;
    }

    public void setAcceptedStudentList(List<ProjectUser> acceptedStudentList){
        this.acceptedStudentList = acceptedStudentList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AcceptedStudentAdapter.AcceptedStudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.acceptedstudent_adapter, viewGroup, false);
        return new AcceptedStudentAdapter.AcceptedStudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AcceptedStudentAdapter.AcceptedStudentViewHolder holder, int i) {
        ProjectUser projectUser = acceptedStudentList.get(i);
        Log.d("countAcceptedListSize", String.valueOf(count));
        if(projectUser.getStatus().equals("1")){
            count++;
            Log.d("countAcceptedListSize", String.valueOf(count));

            holder.name.setText(projectUser.getUser().getUser_name());
        }
    }

    @Override
    public int getItemCount() {
        return acceptedStudentList.size();

    }

    public class AcceptedStudentViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;

        public AcceptedStudentViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.acc_profile_pic_student);
            name = itemView.findViewById(R.id.acc_stud_name_txt);
        }
    }
}
