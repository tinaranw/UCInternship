package com.example.ucinternship.ui.student;

import android.app.SearchManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import android.widget.SearchView;


import com.example.ucinternship.R;

import com.example.ucinternship.adapter.ProjectAdapter;
import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.ui.project.ProjectViewModel;
import com.example.ucinternship.utils.SharedPreferenceHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProjectOfferFragment extends Fragment {

    @BindView(R.id.offereducation_img)
    ImageView education;
    @BindView(R.id.offerevent_img)
    ImageView event;
    @BindView(R.id.offerother_img)
    ImageView other;
    @BindView(R.id.projectoffer_rv)
    RecyclerView rv;
    @BindView(R.id.projectoffersearchbar_search)
    SearchView search;

    private ProjectViewModel viewModel;
    private ProjectAdapter adapter;
    private SharedPreferenceHelper helper;

    public ProjectOfferFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project_offer, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Project Offers");
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        ButterKnife.bind(this, view);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(ProjectViewModel.class);
        viewModel.init(helper.getAccessToken());
        viewModel.getProjects().observe(requireActivity(), observeViewModel);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ProjectAdapter(getActivity());
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Project Offers");
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }


    private Observer<List<Project>> observeViewModel = new Observer<List<Project>>() {
        @Override
        public void onChanged(List<Project> projects) {
            if(projects != null){
                adapter.setProjectList(projects);
                adapter.notifyDataSetChanged();
                rv.setAdapter(adapter);

            } else {

            }
        }
    };
}