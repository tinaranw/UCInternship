package com.example.ucinternship.ui;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ucinternship.Glovar;
import com.example.ucinternship.R;
import com.example.ucinternship.adapter.AcceptedStudentAdapter;
import com.example.ucinternship.adapter.ProjectAdapter;
import com.example.ucinternship.adapter.StudentAdapter;
import com.example.ucinternship.adapter.TaskAdapter;
import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.model.local.ProjectUser;
import com.example.ucinternship.model.local.Supervisor;
import com.example.ucinternship.model.local.Task;
import com.example.ucinternship.ui.viewmodel.ProfileViewModel;
import com.example.ucinternship.ui.viewmodel.ProjectDetailViewModel;
import com.example.ucinternship.ui.viewmodel.ProjectViewModel;
import com.example.ucinternship.ui.viewmodel.TaskViewModel;
import com.example.ucinternship.utils.Constants;
import com.example.ucinternship.utils.SharedPreferenceHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailProjectFragment extends Fragment implements LifecycleOwner {

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
    @BindView(R.id.projectdeadline_txt)
    TextView projectdeadline;
    @BindView(R.id.spv_name_txt)
    TextView projectspv;
    @BindView(R.id.projectattachmentnotice_txt)
    TextView projectattnotice;
    @BindView(R.id.rv_task)
    RecyclerView task_rv;
    @BindView(R.id.appliedstudents_rv)
    RecyclerView appliedstudents_rv;
    @BindView(R.id.acceptedstudents_rv)
    RecyclerView acceptedstudents_rv;
    @BindView(R.id.apply_project_btn)
    FloatingActionButton apply;

    Dialog dialog;
    private Project project;
    private ProjectDetailViewModel viewModel;
    private TaskAdapter taskAdapter;
    private StudentAdapter studentAdapter;
    private AcceptedStudentAdapter acceptedStudentAdapter;
    private TaskViewModel taskViewModel;
    private SharedPreferenceHelper helper;
    private String checkStudent, checkStaff, checkLecturer;
    private ProjectDetailViewModel projectDetailViewModel;

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
        projectDetailViewModel = ViewModelProviders.of(this).get(ProjectDetailViewModel.class);
        Log.d("tokendetailproj", helper.getAccessToken());
        projectDetailViewModel.init(helper.getAccessToken());

        dialog = Glovar.loadingDialog(getActivity());
        checkStudent = "App'Models'Student";
        checkStaff = "App'Models'Staff";
        checkLecturer = "App'Models'Lecturer";

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(ProjectDetailViewModel.class);
        viewModel.init(helper.getAccessToken());

        if (getArguments() != null) {
            project = DetailProjectFragmentArgs.fromBundle(getArguments()).getProject();
            loadProject(view, project);
        }
        taskViewModel = ViewModelProviders.of(requireActivity()).get(TaskViewModel.class);
        taskViewModel.init(helper.getAccessToken());
        taskViewModel.getTaskLists(project.getProject_id()).observe(requireActivity(), observeViewModel);
        task_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        taskAdapter = new TaskAdapter(getActivity());

        apply.setOnClickListener(v -> {
            apply();
        });

    }


    private void loadProject(View view, Project project){
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

        if(project.getAttachments().size() == 0){
            projectattnotice.setText("No project attachments.");
        } else if (project.getAttachments().size() == 1) {
            projectattnotice.setText("There is 1 file attached to this project. Check the website to view them.");
        } else {
            projectattnotice.setText("There are currently " + project.getAttachments().size() + " files attached to this project. Check the website to view them.");
        }

        projectname.setText(project.getProject_name());
        Log.d("trial", "please work");
        Log.d("student size", String.valueOf((project.getApplicants()).size()));
        //load icon
        if(project.getProject_status().equalsIgnoreCase("0")){
            projectstatus.setText("Available");
        } else if(project.getProject_status().equalsIgnoreCase("1")){
            projectstatus.setText("Ongoing");
            getView().findViewById(R.id.apply_project_btn).setVisibility(View.GONE);
        } else if(project.getProject_status().equalsIgnoreCase("2")){
            projectstatus.setText("Completed");
            getView().findViewById(R.id.apply_project_btn).setVisibility(View.GONE);
        } else if(project.getProject_status().equalsIgnoreCase("3")){
            projectstatus.setText("Suspended");
            getView().findViewById(R.id.apply_project_btn).setVisibility(View.GONE);
        }

        projectdesc.setText(project.getProject_description());
        projectspv.setText(project.getProject_spv().getSupervisor_name());

        if(helper.getRole().equalsIgnoreCase(checkStudent.replace("'", "\\"))){

            getView().findViewById(R.id.incomingapplicationsdetail_inc).setVisibility(View.GONE);
            getView().findViewById(R.id.acceptedstudentsdetail_inc).setVisibility(View.GONE);
        } else {
            getView().findViewById(R.id.apply_project_btn).setVisibility(View.GONE);
            appliedstudents_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
            studentAdapter = new StudentAdapter(getActivity());

            acceptedstudents_rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
            acceptedStudentAdapter = new AcceptedStudentAdapter(getActivity());

            studentAdapter.setStudentList( project.getPending_students());
            studentAdapter.notifyDataSetChanged();
            appliedstudents_rv.setAdapter(studentAdapter);

            acceptedStudentAdapter.setAcceptedStudentList( project.getAccepted_students());
            acceptedStudentAdapter.notifyDataSetChanged();
            acceptedstudents_rv.setAdapter(acceptedStudentAdapter);
        }

        if(project.getProject_status().equals("0")){
            getView().findViewById(R.id.rv_task).setVisibility(View.GONE);
        } else  if(project.getProject_status().equals("1")){
            Log.d("projectstatus", project.getProject_status());
        } else  if(project.getProject_status().equals("2")){
            Log.d("projectstatus", project.getProject_status());
        } else {
            Log.d("projectstatus", project.getProject_status());
        }

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

    public void apply(){

        new AlertDialog.Builder(getActivity())
                .setTitle("Confirmation")
                .setIcon(R.drawable.ic_logo)
                .setMessage("Do you want to apply to this project?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    dialog.show();
                    new Handler(Looper.getMainLooper()).postDelayed(() -> {
                        dialog.cancel();


                    }, 2000);
                })
                .setNegativeButton("No", (dialog, which) -> dialog.cancel())
                .create()
                .show();

    }



}