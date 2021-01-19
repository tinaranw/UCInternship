package com.example.ucinternship.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ucinternship.R;
import com.example.ucinternship.adapter.ProgressAdapter;
import com.example.ucinternship.adapter.TaskAdapter;
import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.local.Task;
import com.example.ucinternship.ui.viewmodel.ProfileViewModel;
import com.example.ucinternship.ui.viewmodel.ProgressViewModel;
import com.example.ucinternship.ui.viewmodel.ProjectDetailViewModel;
import com.example.ucinternship.ui.viewmodel.TaskDetailViewModel;
import com.example.ucinternship.ui.viewmodel.TaskViewModel;
import com.example.ucinternship.utils.SharedPreferenceHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailTaskFragment extends Fragment {

    @BindView(R.id.task_name_txt)
    TextView tasktitle;
    @BindView(R.id.task_desc_txt)
    TextView taskdesc;
    @BindView(R.id.task_status_txt)
    TextView taskstatus;
    @BindView(R.id.progress_rv)
    RecyclerView progress_rv;


    private Task task;
    private TaskDetailViewModel viewModel;
    private SharedPreferenceHelper helper;
    private ProgressAdapter progressAdapter;
    private ProgressViewModel progressViewModel;
    private ProfileViewModel profileViewModel;
    private String checkStudent, checkStaff, checkLecturer;

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
        viewModel = ViewModelProviders.of(requireActivity()).get(TaskDetailViewModel.class);
        viewModel.init(helper.getAccessToken());

        if (getArguments() != null) {
            task = DetailTaskFragmentArgs.fromBundle(getArguments()).getTask();
            loadTask(task);
        }

        progressViewModel = ViewModelProviders.of(requireActivity()).get(ProgressViewModel.class);
        progressViewModel.init(helper.getAccessToken());

        checkStudent = "App'Models'Student";
        checkStaff = "App'Models'Staff";
        checkLecturer = "App'Models'Lecturer";

        profileViewModel = ViewModelProviders.of(requireActivity()).get(ProfileViewModel.class);
        profileViewModel.init(helper.getAccessToken());
        Log.d("roleku", "" + helper.getRole());
        Log.d("task fragment - task id", "" + task.getTask_id());
        Log.d("task fragment - name", "" + task.getTask_name());
        progressViewModel.getProgressLists(task.getTask_id()).observe(requireActivity(), observeViewModel);

        progress_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        progressAdapter = new ProgressAdapter(getActivity());
    }

    private void loadTask(Task task) {

        tasktitle.setText(task.getTask_name());
        taskdesc.setText(task.getTask_description());
        if (task.getTask_approved().equalsIgnoreCase("0")) {
            taskstatus.setText("Ongoing");
        } else if (task.getTask_approved().equalsIgnoreCase("1")) {
            taskstatus.setText("Completed");
        }
    }

    private Observer<List<Progress>> observeViewModel = progress -> {
        if (progress != null) {
            Log.d("ProgressChecking", String.valueOf(progress.size()));
            progressAdapter.setProgressList(progress);
            progressAdapter.notifyDataSetChanged();
            progress_rv.setAdapter(progressAdapter);
        } else {

        }
    };
}