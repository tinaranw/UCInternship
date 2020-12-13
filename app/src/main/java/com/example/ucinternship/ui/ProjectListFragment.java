package com.example.ucinternship.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.ucinternship.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectListFragment extends Fragment {

    @BindView(R.id.request_img)
    ImageView request;
    @BindView(R.id.education_img)
    ImageView education;
    @BindView(R.id.event_img)
    ImageView event;
    @BindView(R.id.other_img)
    ImageView other;
    @BindView(R.id.no_project_img)
    ImageView noproject;
    @BindView(R.id.projectlist_rv)
    RecyclerView rv;
    @BindView(R.id.projectsearchbar_search)
    SearchView search;

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
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Project List");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }
}