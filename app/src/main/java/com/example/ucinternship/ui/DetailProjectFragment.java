package com.example.ucinternship.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.ui.viewmodel.ProjectDetailViewModel;
import com.example.ucinternship.ui.viewmodel.ProjectViewModel;
import com.example.ucinternship.utils.SharedPreferenceHelper;

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

    private Project project;
    private ProjectDetailViewModel viewModel;
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
}