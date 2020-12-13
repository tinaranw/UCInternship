package com.example.ucinternship.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ucinternship.R;

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
    @BindView(R.id.phone_txt)
    TextView phone;
    @BindView(R.id.projectdeadline_txt)
    TextView projectdeadline;
    @BindView(R.id.spv_name_txt)
    TextView projectspv;


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
    }
}