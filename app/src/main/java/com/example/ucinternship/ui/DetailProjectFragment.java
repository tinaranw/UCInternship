package com.example.ucinternship.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ucinternship.R;
import com.example.ucinternship.adapter.ProjectAdapter;
import com.example.ucinternship.adapter.TaskAdapter;
import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.local.Task;
import com.example.ucinternship.ui.viewmodel.ProjectDetailViewModel;
import com.example.ucinternship.ui.viewmodel.ProjectViewModel;
import com.example.ucinternship.ui.viewmodel.TaskViewModel;
import com.example.ucinternship.utils.SharedPreferenceHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailProjectFragment extends Fragment {

    @BindView(R.id.detailproject_icon)
    ImageView icon;
    @BindView(R.id.projectname_txt)
    TextView projectname;
    @BindView(R.id.projectstatus_txt)
    TextView projectstatus;
    @BindView(R.id.projectcategory_txt)
    TextView projectcategory;
    @BindView(R.id.projectdesc_txt)
    TextView projectdesc;
    @BindView(R.id.projectduration_txt)
    TextView projectduration;
    @BindView(R.id.projectdeadline_txt)
    TextView projectdeadline;
    @BindView(R.id.spv_name_txt)
    TextView projectspv;
    @BindView(R.id.rv_task)
    RecyclerView task_rv;

    private Project project;
    private ProjectDetailViewModel viewModel;
    private TaskAdapter taskAdapter;
    private TaskViewModel taskViewModel;
    private SharedPreferenceHelper helper;

    public DetailProjectFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_project, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(ProjectDetailViewModel.class);
        viewModel.init(helper.getAccessToken());

        if (getArguments() != null) {
            project = DetailProjectFragmentArgs.fromBundle(getArguments()).getProject();
            loadProject(project);
        }
        taskViewModel = ViewModelProviders.of(requireActivity()).get(TaskViewModel.class);
        taskViewModel.init(helper.getAccessToken());
        taskViewModel.getTasks().observe(requireActivity(), observeViewModel);

        task_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        taskAdapter = new TaskAdapter(getActivity());

    }


    private void loadProject(Project project){
        //load icon
        if(project.getProject_category().equalsIgnoreCase("0")){
            icon.setImageResource(R.drawable.ic_event);
            projectcategory.setText("Event");
        } else if(project.getProject_category().equalsIgnoreCase("1")){
            icon.setImageResource(R.drawable.ic_material);
            projectcategory.setText("Education");
        } else if(project.getProject_category().equalsIgnoreCase("2")){
            icon.setImageResource(R.drawable.ic_others);
            projectcategory.setText("Other");
        }

        projectname.setText(project.getProject_name());

        //load icon
        if(project.getProject_status().equalsIgnoreCase("0")){
            projectstatus.setText("Available");
        } else if(project.getProject_status().equalsIgnoreCase("1")){
            projectstatus.setText("Ongoing");
        } else if(project.getProject_status().equalsIgnoreCase("2")){
            projectstatus.setText("Completed");
        } else if(project.getProject_status().equalsIgnoreCase("3")){
            projectstatus.setText("Suspended");
        }

        projectdesc.setText(project.getProject_description());
        projectspv.setText(project.getProject_spv().getSupervisor_name());
    }

    private Observer<List<Task>> observeViewModel = tasks -> {
        if(tasks != null){
            Log.d("TaskChecking", String.valueOf(tasks.size()));
            taskAdapter.setTaskList(tasks);
            taskAdapter.notifyDataSetChanged();
            task_rv.setAdapter(taskAdapter);
        } else {

        }
    };
}