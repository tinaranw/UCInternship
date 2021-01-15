package com.example.ucinternship.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.ucinternship.R;
import com.example.ucinternship.adapter.ProjectAdapter;
import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.ui.viewmodel.ProjectViewModel;
import com.example.ucinternship.utils.SharedPreferenceHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectListFragment extends Fragment {

    @BindView(R.id.education_img)
    ImageView education;
    @BindView(R.id.event_img)
    ImageView event;
    @BindView(R.id.other_img)
    ImageView other;
    @BindView(R.id.no_project_img)
    ImageView noproject;
    @BindView(R.id.noproject_txt)
    TextView noproject_txt;
    @BindView(R.id.projectlist_rv)
    RecyclerView rv;
    @BindView(R.id.projectsearchbar_search)
    SearchView search;

    private ProjectViewModel viewModel;
    private ProjectAdapter adapter;
    private SharedPreferenceHelper helper;

    public ProjectListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(ProjectViewModel.class);
        viewModel.init(helper.getAccessToken());
        viewModel.getProjects().observe(requireActivity(), observeViewModel);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ProjectAdapter(getActivity());
        searchList();
    }

    public void searchList(){
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private Observer<List<Project>> observeViewModel = new Observer<List<Project>>() {
        @Override
        public void onChanged(List<Project> projects) {
            if(projects != null){
                adapter.setProjectList(projects);
                adapter.notifyDataSetChanged();
                rv.setAdapter(adapter);
                noproject.setVisibility(View.INVISIBLE);
                noproject_txt.setVisibility(View.INVISIBLE);
            } else {
                noproject.setVisibility(View.VISIBLE);
                noproject_txt.setVisibility(View.VISIBLE);
            }
        }
    };

    private void showLoading(Boolean state) {
        if (state) {
            rv.setVisibility(View.GONE);
        } else {
            rv.setVisibility(View.VISIBLE);
        }
    }
}