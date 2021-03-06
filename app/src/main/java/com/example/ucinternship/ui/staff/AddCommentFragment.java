package com.example.ucinternship.ui.staff;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Progress;
import com.example.ucinternship.ui.DetailProgressFragment;
import com.example.ucinternship.ui.DetailProgressFragmentArgs;
import com.example.ucinternship.ui.DetailProgressFragmentDirections;
import com.example.ucinternship.ui.viewmodel.ProfileViewModel;
import com.example.ucinternship.ui.viewmodel.ProgressViewModel;
import com.example.ucinternship.utils.SharedPreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddCommentFragment extends Fragment {

    @BindView(R.id.comment_inp)
    EditText comment;
    @BindView(R.id.approve_progress_btn)
    Button approve;
    @BindView(R.id.comment_tb)
    Toolbar toolbar;

    @BindView(R.id.decline_progress_btn)
    Button decline;
    private Progress progress;
    private ProgressViewModel viewModel;
    private SharedPreferenceHelper helper;

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
        viewModel = ViewModelProviders.of(requireActivity()).get(ProgressViewModel.class);
        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel.init(helper.getAccessToken());

        if (getArguments() != null) {
            progress = DetailProgressFragmentArgs.fromBundle(getArguments()).getProgress();
            Log.d("progressstart", progress.getProgress_start());
            Log.d("progressend", progress.getProgress_end());
            Log.d("progressIDout", "asd"+progress.getProgress_id());
            approve.setOnClickListener(v -> {
                approve(view);
            });
            decline.setOnClickListener(v -> {
                decline(view);
            });
        }

        backButtonTb();

    }

    public void approve(View view) {
        String progress_comment = comment.getText().toString().trim();
        Log.d("progressID", "asd"+progress.getProgress_id());
        Log.d("progressstart", progress.getProgress_start());
        Log.d("progressend", progress.getProgress_end());
        viewModel.approveProgress(progress.getProgress_id(), progress_comment).observe(requireActivity(), tokenResponse -> {
            if (tokenResponse != null) {
                NavDirections action = AddCommentFragmentDirections.ActionAddCommentToDetailProgress(progress);
                Navigation.findNavController(view).navigate(action);
            };
        });
    }

    public void decline(View view) {
        String progress_comment = comment.getText().toString().trim();
        viewModel.declineProgress(progress.getProgress_id(), progress_comment).observe(requireActivity(), tokenResponse -> {
            if (tokenResponse != null) {
                NavDirections action = AddCommentFragmentDirections.ActionAddCommentToDetailProgress(progress);
                Navigation.findNavController(view).navigate(action);
            };
        });
    }
    public void backButtonTb() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bisa pake ini jg
//                Fragment fragment = new DetailProgressFragment();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragment, fragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

//                Bundle bundle = new Bundle();
//                progress = DetailProgressFragmentArgs.fromBundle(getArguments()).getProgress();
//                bundle.putParcelable("progress", progress);
//                new DetailProgressFragment().setArguments(bundle);
//
//                Log.d("testProgress", String.valueOf(progress.getProgress_id()));
//
//                fragmentTransaction.replace(R.id.fragment, new DetailProgressFragment()).commit();
//                fragmentTransaction.addToBackStack(null);

                Bundle bundle = new Bundle();
                progress = DetailProgressFragmentArgs.fromBundle(getArguments()).getProgress();
                bundle.putParcelable("progress", progress);
                DetailProgressFragment myFragment = new DetailProgressFragment();
                myFragment.setArguments(bundle);
                Log.d("testProgress", String.valueOf(progress.getProgress_id()));

                fragmentTransaction.replace(R.id.fragment,myFragment).commit();
                fragmentTransaction.addToBackStack(null);

            }
        });
    }

}