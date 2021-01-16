package com.example.ucinternship.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ucinternship.R;
import com.example.ucinternship.adapter.IncomingProgressAdapter;
import com.example.ucinternship.adapter.ProgressAdapter;
import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.adapter.IncomingProgressAdapter;
import com.example.ucinternship.adapter.ProgressAdapter;
import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.model.local.Student;
import com.example.ucinternship.model.local.Supervisor;
import com.example.ucinternship.model.local.Task;
import com.example.ucinternship.ui.viewmodel.ProfileViewModel;
import com.example.ucinternship.ui.viewmodel.ProgressViewModel;
import com.example.ucinternship.ui.viewmodel.ProjectViewModel;
import com.example.ucinternship.ui.viewmodel.ProgressViewModel;
import com.example.ucinternship.utils.Constants;
import com.example.ucinternship.utils.SharedPreferenceHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardFragment extends Fragment {


    @BindView(R.id.dashboardname_text)
    TextView name;
    @BindView(R.id.profilepic_img)
    ImageView image;
    @BindView(R.id.recentprogress_rv)
    RecyclerView rv;
    @BindView(R.id.totalpending_txt)
    TextView pending;
    @BindView(R.id.totalaccepted_txt)
    TextView accept;

    private ProfileViewModel profileViewModel;
    private SharedPreferenceHelper helper;
    private String checkStudent, checkStaff, checkLecturer;
    private IncomingProgressAdapter incomingProgressAdapter;
    private ProgressViewModel progressViewModel;
    private ProjectViewModel projectViewModel;
    private Project project;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        checkStudent = "App'Models'Student";
        checkStaff = "App'Models'Staff";
        checkLecturer = "App'Models'Lecturer";

        helper = SharedPreferenceHelper.getInstance(requireActivity());

        profileViewModel = ViewModelProviders.of(requireActivity()).get(ProfileViewModel.class);
        profileViewModel.init(helper.getAccessToken());

        progressViewModel = ViewModelProviders.of(requireActivity()).get(ProgressViewModel.class);
        progressViewModel.init(helper.getAccessToken());
        progressViewModel.getSpvProgresses().observe(requireActivity(), observeViewModel);

        projectViewModel = ViewModelProviders.of(requireActivity()).get(ProjectViewModel.class);
        projectViewModel.init(helper.getAccessToken());
        projectViewModel.getPending().observe(requireActivity(), observePendingViewModel);

        projectViewModel = ViewModelProviders.of(requireActivity()).get(ProjectViewModel.class);
        projectViewModel.init(helper.getAccessToken());
        projectViewModel.getAccept().observe(requireActivity(), observeAcceptViewModel);

        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        incomingProgressAdapter = new IncomingProgressAdapter(getActivity());

        Log.d("roleku", "" + helper.getRole());
        if (helper.getRole().equalsIgnoreCase(checkStudent.replace("'", "\\"))) {
            Log.d("checkstudent", "" + checkStudent.replace("'", "\\"));
            profileViewModel.getStudentDetails(helper.getUserID()).observe(requireActivity(), observeStudentDetailViewModel);
        } else {
            profileViewModel.getSupervisorDetails(helper.getUserID()).observe(requireActivity(), observeSupervisorDetailViewModel);
        }
    }

    private Observer<List<Project>> observePendingViewModel = new Observer<List<Project>>() {
        @Override
        public void onChanged(List<Project> projects) {
                pending.setText(String.valueOf(projects.size()));
        }
    };
    private Observer<List<Project>> observeAcceptViewModel = new Observer<List<Project>>() {
        @Override
        public void onChanged(List<Project> projects) {
            accept.setText(String.valueOf(projects.size()));
        }
    };;

    private final Observer<Student> observeStudentDetailViewModel = details -> {
        if (details != null) {
            if(details.getStudent_photo() == null){
                image.setImageResource(R.drawable.ic_asset_7);
            } else {
                Glide.with(getActivity()).load(Constants.BASE_IMAGE_URL + "student/" + details.getStudent_photo()).into(image);
            }
            name.setText(details.getStudent_name());
            Log.d("nimku", "" + details.getStudent_nim());
        }
        getView().findViewById(R.id.recentprog_inc).setVisibility(View.GONE);
    };

    private final Observer<Supervisor> observeSupervisorDetailViewModel = details -> {
        if (details != null) {
            if (helper.getRole().equalsIgnoreCase(checkStaff.replace("'", "\\"))) {
                if(details.getSupervisor_photo() == null){
                    image.setImageResource(R.drawable.ic_asset_7);
                } else {
                    Glide.with(getActivity()).load(Constants.BASE_IMAGE_URL + "staff/" + details.getSupervisor_photo()).into(image);
                }
            } else {
                if(details.getSupervisor_photo() == null){
                    image.setImageResource(R.drawable.ic_asset_7);
                } else {
                    Glide.with(getActivity()).load(Constants.BASE_IMAGE_URL + "lecturer/" + details.getSupervisor_photo()).into(image);
                }
            }
            name.setText(details.getSupervisor_name());
            getView().findViewById(R.id.yourapp_inc).setVisibility(View.GONE);
        }
    };

    //incoming progress adapter
    private Observer<List<Progress>> observeViewModel = progress -> {
        if(progress != null){
            Log.d("ProgressChecking", String.valueOf(progress.size()));
            incomingProgressAdapter.setProgressList(progress);
            incomingProgressAdapter.notifyDataSetChanged();
            rv.setAdapter(incomingProgressAdapter);
        } else {

        }
    };
}