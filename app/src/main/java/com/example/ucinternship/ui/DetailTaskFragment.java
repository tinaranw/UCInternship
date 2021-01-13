package com.example.ucinternship.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.local.Task;
import com.example.ucinternship.ui.viewmodel.ProjectDetailViewModel;
import com.example.ucinternship.utils.SharedPreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailTaskFragment extends Fragment {

    @BindView(R.id.task_name_txt)
    TextView tasktitle;
    @BindView(R.id.task_desc_txt)
    TextView taskdesc;
    @BindView(R.id.task_status_txt)
    TextView taskstatus;
    @BindView(R.id.pic_name_txt)
    TextView taskpic;
    @BindView(R.id.progress_btn)
    Button addbtn;

    private Task task;
    private ProjectDetailViewModel viewModel;
    private SharedPreferenceHelper helper;

    public DetailTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_task, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(ProjectDetailViewModel.class);
        viewModel.init(helper.getAccessToken());
    }
}