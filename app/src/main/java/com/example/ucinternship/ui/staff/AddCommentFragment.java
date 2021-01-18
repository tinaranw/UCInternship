package com.example.ucinternship.ui.staff;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.ui.DetailProgressFragmentArgs;
import com.example.ucinternship.ui.DetailProgressFragmentDirections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddCommentFragment extends Fragment {

    @BindView(R.id.comment_inp)
    EditText comment;
    @BindView(R.id.approve_progress_btn)
    Button approve;

    @BindView(R.id.decline_progress_btn)
    Button decline;
    private Progress progress;
    public AddCommentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_comment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        if (getArguments() != null) {
            progress = DetailProgressFragmentArgs.fromBundle(getArguments()).getProgress();

            approve.setOnClickListener(v -> {
                NavDirections action = AddCommentFragmentDirections.ActionAddCommentToDetailProgress(progress);
                Navigation.findNavController(view).navigate(action);
            });

            decline.setOnClickListener(v -> {
                NavDirections action = AddCommentFragmentDirections.ActionAddCommentToDetailProgress(progress);
                Navigation.findNavController(view).navigate(action);
            });
        }



    }
}