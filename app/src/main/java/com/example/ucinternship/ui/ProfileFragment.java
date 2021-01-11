package com.example.ucinternship.ui;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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

import com.bumptech.glide.Glide;
import com.example.ucinternship.Glovar;
import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Info;
import com.example.ucinternship.model.local.Student;
import com.example.ucinternship.model.local.Supervisor;
import com.example.ucinternship.ui.viewmodel.LogoutViewModel;
import com.example.ucinternship.ui.viewmodel.ProfileViewModel;
import com.example.ucinternship.utils.Constants;
import com.example.ucinternship.utils.SharedPreferenceHelper;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.lang.Integer.parseInt;


public class ProfileFragment extends Fragment {

    @BindView(R.id.profile_img)
    ImageView image;
    @BindView(R.id.nim_txt)
    TextView nim;
    @BindView(R.id.name_txt)
    TextView name;
    @BindView(R.id.department_txt)
    TextView department;
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

    //kita perlu declare ini, krn fragment butuh data dari sini
    private LogoutViewModel logoutViewModel;
    private ProfileViewModel profileViewModel;
    private SharedPreferenceHelper helper;
    private Student student;
    private Supervisor supervisor;
    private Info info;
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
        ButterKnife.bind(this, view);

        //inisialisasi sharedpref dan viewmodel -> sm spt firebase yg reference bla"
        helper = SharedPreferenceHelper.getInstance(requireActivity());
        logoutViewModel = ViewModelProviders.of(requireActivity()).get(LogoutViewModel.class);

        //untuk token sharedpref
        logoutViewModel.init(helper.getAccessToken());
        dialog = Glovar.loadingDialog(getActivity());
        logout.setOnClickListener(v -> {
            logout(view);
        });


        profileViewModel = ViewModelProviders.of(requireActivity()).get(ProfileViewModel.class);
        profileViewModel.init(helper.getAccessToken());

        if (getArguments() != null) {
            student = ProfileFragmentArgs.fromBundle(getArguments()).getStudent();
            supervisor = ProfileFragmentArgs.fromBundle(getArguments()).getSupervisor();

            if (student != null) {
//                observeViewModel(student.getStudent_user_id());
                initStudent(student);
            } else {
            }
        }
    }
    private void initStudent(Student student) {
        List<Info> info = student.getStudent_info();
        Glide.with(getActivity()).load(Constants.BASE_IMAGE_URL + student.getStudent_photo()).into(image);
        nim.setText(student.getStudent_nim());
        name.setText(student.getStudent_name());
        department.setText(student.getStudent_department_name());
        email.setText(student.getStudent_email());
        remaining.setText(info.get(0).getInfo_time());
    }

//    private void observeViewModel ( int id){
//        if (student != null) {
//            profileViewModel.getRuntime(id).observe(requireActivity(), observeRuntimeViewModel);
//            profileViewModel.getHomepage(id).observe(requireActivity(), observeHomepageViewModel);
//            profileViewModel.getCast(id).observe(requireActivity(), casts -> {
//                if (casts != null) {
//                    castAdapter.setCasts(casts);
//                    castAdapter.notifyDataSetChanged();
//                    rvCasts.setAdapter(castAdapter);
//                    showLoading(false);
//                }
//            });
//        } else {
//            profileViewModel.getTVGenre(id).observe(requireActivity(), genres -> {
//                if (genres != null) {
//                    for (int i = 0; i < genres.size(); i++) {
//                        Genre g = genres.get(i);
//                        if (i < genres.size() - 1) {
//                            detailGenre.append(g.getName() + " | ");
//                        } else {
//                            detailGenre.append(g.getName());
//                        }
//                    }
//                }
//            });
//            profileViewModel.getEpisodes(id).observe(requireActivity(), observeEpisodesViewModel);
//            profileViewModel.getTVHomepage(id).observe(requireActivity(), observeHomepageViewModel);
//            profileViewModel.getTVCast(id).observe(requireActivity(), casts -> {
//                if (casts != null) {
//                    castAdapter.setCasts(casts);
//                    castAdapter.notifyDataSetChanged();
//                    rvCasts.setAdapter(castAdapter);
//                    showLoading(false);
//                }
//            });
//        }
//    }

    //View view ini gunanya untuk nav
    public void logout(View view) {
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
                        //manggil logout di viewmodel
                        logoutViewModel.logout().observe(requireActivity(), message -> {
                            if (message != null) {
                                helper.getInstance(getActivity()).clearPref();
                                NavDirections actions = ProfileFragmentDirections.actionProfileToSplash();
                                Navigation.findNavController(view).navigate(actions);
                                Toast.makeText(requireActivity(), "Successfully logged out!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(requireActivity(), "Failed to logout!", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }, 2000);
                })
                .setNegativeButton("No", (dialog, which) -> dialog.cancel())
                .create()
                .show();
    }


}