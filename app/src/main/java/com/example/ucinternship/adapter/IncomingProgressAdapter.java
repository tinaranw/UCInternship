package com.example.ucinternship.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Progress;

import java.util.List;

public class IncomingProgressAdapter extends RecyclerView.Adapter<IncomingProgressAdapter.IncomingProgressViewHolder>{

    private Context context;
    private List<Progress> progressList;

    public IncomingProgressAdapter(Context context) {
        this.context = context;
    }

    public void setProgressList(List<Progress> progressList){
        this.progressList = progressList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public IncomingProgressAdapter.IncomingProgressViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.incoming_progress_adapter, viewGroup, false);
        return new IncomingProgressAdapter.IncomingProgressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IncomingProgressAdapter.IncomingProgressViewHolder holder, int i) {
        Progress p = progressList.get(i);
        holder.name.setText(p.getProgress_description());
        holder.desc.setText(p.getProgress_description());
    }

    @Override
    public int getItemCount() {
        return progressList.size();
    }

    public class IncomingProgressViewHolder extends RecyclerView.ViewHolder {
        TextView name, desc;
        public IncomingProgressViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rpprojectname_txt);
            desc = itemView.findViewById(R.id.rptaskname_txt);
        }
    }
}
