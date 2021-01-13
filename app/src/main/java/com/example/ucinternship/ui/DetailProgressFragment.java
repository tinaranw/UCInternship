package com.example.ucinternship.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.model.local.Task;
import com.example.ucinternship.ui.viewmodel.ProgressDetailViewModel;
import com.example.ucinternship.ui.viewmodel.ProgressViewModel;
import com.example.ucinternship.ui.viewmodel.ProjectDetailViewModel;
import com.example.ucinternship.ui.viewmodel.TaskDetailViewModel;
import com.example.ucinternship.utils.SharedPreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailProgressFragment extends Fragment {

    @BindView(R.id.pic_name_progress_txt)
    TextView pic;
    @BindView(R.id.desc_progress_txt)
    TextView desc;
    @BindView(R.id.start_time_txt)
    TextView start;
    @BindView(R.id.end_time_txt)
    TextView end;
    @BindView(R.id.no_attachment_txt)
    TextView attachment;
    @BindView(R.id.comment_txt)
    TextView comment;
    @BindView(R.id.status_box_txt)
    TextView status;

    private Progress progress;
    private ProgressDetailViewModel viewModel;
    private SharedPreferenceHelper helper;

    public DetailProgressFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_progress, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(ProgressDetailViewModel.class);
        viewModel.init(helper.getAccessToken());

        if (getArguments() != null) {
            progress = DetailProgressFragmentArgs.fromBundle(getArguments()).getProgress();
            loadProgress(progress);
        }
    }

    private void loadProgress(Progress progress){

        desc.setText(progress.getProgress_description());
        start.setText(progress.getProgress_start());
        end.setText(progress.getProgress_end());
        comment.setText(progress.getProgress_comment());
        if(progress.getProgress_approved().equalsIgnoreCase("0")){
            status.setText("Ongoing");
        } else if(progress.getProgress_approved().equalsIgnoreCase("1")){
            status.setText("Accepted");
        }else if(progress.getProgress_approved().equalsIgnoreCase("2")){
            status.setText("Declined");
        }
    }
}