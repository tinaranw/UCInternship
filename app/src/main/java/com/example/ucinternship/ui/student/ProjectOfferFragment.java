package com.example.ucinternship.ui.student;

import android.app.SearchManager;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ucinternship.R;
import com.example.ucinternship.adapter.ProjectAdapter;
import com.example.ucinternship.model.local.Project;
import com.example.ucinternship.ui.project.ProjectViewModel;
import com.example.ucinternship.utils.SharedPreferenceHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectOfferFragment extends Fragment {

    @BindView(R.id.projectoffer_rv)
    RecyclerView rv;
    @BindView(R.id.noprojectoffer_img)
    ImageView noproject;
    @BindView(R.id.noprojectoffer_txt)
    TextView noproject_txt;

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
        ButterKnife.bind(this, view);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(ProjectViewModel.class);
        viewModel.init(helper.getAccessToken());
        Log.d("gettingaccesstoken", helper.getAccessToken());
        viewModel.getProjects().observe(requireActivity(), observeViewModel);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new ProjectAdapter(getActivity());

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

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu_main, menu);
//        SearchManager searchManager = getSystemService(SEARCH_SER)
//        super.onCreateOptionsMenu(menu, inflater);
//    }
}