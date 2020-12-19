package com.example.ucinternship.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ucinternship.Glovar;
import com.example.ucinternship.R;
import com.example.ucinternship.ui.login.LoginViewModel;
import com.example.ucinternship.ui.logout.LogoutViewModel;
import com.example.ucinternship.ui.splash.SplashFragment;
import com.example.ucinternship.ui.splash.SplashFragmentDirections;
import com.example.ucinternship.utils.SharedPreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProfileFragment extends Fragment {

    @BindView(R.id.profile_img)
    ImageView image;
    @BindView(R.id.nim_txt)
    TextView nim;
    @BindView(R.id.name_txt)
    TextView name;
    @BindView(R.id.department_txt)
    TextView departemnt;
    @BindView(R.id.email_txt)
    TextView email;
    @BindView(R.id.address_txt)
    TextView address;
    @BindView(R.id.phone_txt)
    TextView phone;
    @BindView(R.id.hour_remaining_txt)
    TextView remaining;
    @BindView(R.id.hour_completed_txt)
    TextView completed;
    @BindView(R.id.edit_btn)
    ImageView edit;
    @BindView(R.id.logout_btn)
    Button logout;

    private LogoutViewModel viewModel;
    private SharedPreferenceHelper helper;
    Dialog dialog;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        helper = SharedPreferenceHelper.getInstance(requireActivity());
        viewModel = ViewModelProviders.of(requireActivity()).get(LogoutViewModel.class);
        viewModel.init(helper.getAccessToken());
        dialog = Glovar.loadingDialog(getActivity());
        logout.setOnClickListener(v -> {
            logout(view);
        });
    }

    public void logout(View view){
        new AlertDialog.Builder(getActivity())
                .setTitle("Confirmation")
                .setIcon(R.drawable.ic_logo)
                .setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    dialog.show();
                    new Handler(Looper.getMainLooper()).postDelayed(() -> {
                        dialog.cancel();
                        Log.d("accesstokenlogout", helper.getAccessToken());
                        viewModel.logout().observe(requireActivity(), message -> {
                            if(message != null){
                                helper.getInstance(getActivity()).clearPref();
                                NavDirections actions = ProfileFragmentDirections.actionProfileToSplash();
                                Navigation.findNavController(view).navigate(actions);
                                Toast.makeText(requireActivity(),  "Successfully logged out!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(requireActivity(),  "Failed to logout!", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }, 2000);
                })
                .setNegativeButton("No", (dialog, which) -> dialog.cancel())
                .create()
                .show();
    }


}