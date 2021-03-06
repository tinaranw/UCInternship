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
import androidx.recyclerview.widget.DividerItemDecoration;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ucinternship.Glovar;
import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Info;
import com.example.ucinternship.model.local.Student;
import com.example.ucinternship.model.local.Supervisor;
import com.example.ucinternship.model.local.Task;
import com.example.ucinternship.model.local.User;
import com.example.ucinternship.ui.viewmodel.LogoutViewModel;
import com.example.ucinternship.ui.viewmodel.ProfileViewModel;
import com.example.ucinternship.ui.viewmodel.TaskDetailViewModel;
import com.example.ucinternship.ui.viewmodel.TaskViewModel;
import com.example.ucinternship.utils.Constants;
import com.example.ucinternship.utils.SharedPreferenceHelper;

import org.json.JSONArray;
import org.json.JSONObject;

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
    @BindView(R.id.department_initial_txt)
    TextView department_initial;
    @BindView(R.id.email_txt)
    TextView email;
    @BindView(R.id.batch_txt)
    TextView batch;
    @BindView(R.id.gender_txt)
    TextView gender;
    @BindView(R.id.line_txt)
    TextView line;
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
    @BindView(R.id.profile_progress_bar)
    ProgressBar loading;

    //kita perlu declare ini, krn fragment butuh data dari sini
    private LogoutViewModel logoutViewModel;
    private ProfileViewModel profileViewModel;
    private TaskViewModel taskViewModel;
    private SharedPreferenceHelper helper;
    private Task task;
    Dialog dialog;
    private String checkStudent, checkStaff, checkLecturer;
    float timeCompleted;


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
        checkStudent = "App'Models'Student";
        checkStaff = "App'Models'Staff";
        checkLecturer = "App'Models'Lecturer";
        loading(true);
        //inisialisasi sharedpref dan viewmodel -> sm spt firebase yg reference bla"
        helper = SharedPreferenceHelper.getInstance(requireActivity());
        logoutViewModel = ViewModelProviders.of(requireActivity()).get(LogoutViewModel.class);

        //untuk token sharedpref
        logoutViewModel.init(helper.getAccessToken());

        taskViewModel = ViewModelProviders.of(requireActivity()).get(TaskViewModel.class);
        taskViewModel.init(helper.getAccessToken());
        taskViewModel.getTasks().observe(requireActivity(), observeCompletedViewModel);

        dialog = Glovar.loadingDialog(getActivity());
        logout.setOnClickListener(v -> {
            logout(view);
        });
        edit.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity().getApplication(), EditProfileActivity.class);
            startActivity(intent);
        });
        profileViewModel = ViewModelProviders.of(requireActivity()).get(ProfileViewModel.class);
        profileViewModel.init(helper.getAccessToken());
        Log.d("roleku", "" + helper.getRole());
        if (helper.getRole().equalsIgnoreCase(checkStudent.replace("'", "\\"))) {
            Log.d("checkstudent", "" + checkStudent.replace("'", "\\"));
            profileViewModel.getStudentDetails(helper.getUserID()).observe(requireActivity(), observeStudentDetailViewModel);
        } else {
            profileViewModel.getSupervisorDetails(helper.getUserID()).observe(requireActivity(), observeSupervisorDetailViewModel);
        }

    }

    private final Observer<Student> observeStudentDetailViewModel = details -> {
        if (details != null) {
            loading(false);
            Info info = details.getStudent_info();
            if (details.getStudent_photo() == null) {
                image.setImageResource(R.drawable.ic_asset_7);
            } else {
                Glide.with(getActivity()).load(Constants.BASE_IMAGE_URL + "student/" + details.getStudent_photo()).into(image);
            }

            nim.setText(details.getStudent_nim());
            name.setText(details.getStudent_name());
            department.setText(details.getStudent_department_name());
            department_initial.setText("(" + details.getStudent_department_initial() + ")");
            email.setText(details.getStudent_email());
            phone.setText(details.getStudent_phone());
            line.setText(details.getStudent_line());
            if (details.getStudent_gender().equalsIgnoreCase("m")) {
                gender.setText(R.string.gender_male);
            } else {
                gender.setText(R.string.gender_female);
            }
            remaining.setText(info.getInfo_time());
            Log.d("nimku", "" + details.getStudent_nim());
        }
    };

    private final Observer<Supervisor> observeSupervisorDetailViewModel = details -> {
        if (details != null) {
            loading(false);
            if (details.getSupervisor_photo() == null) {
                image.setImageResource(R.drawable.ic_asset_7);
            } else {
                Glide.with(getActivity()).load(Constants.BASE_IMAGE_URL + "supervisor/" + details.getSupervisor_photo()).into(image);
            }
            nim.setText(details.getSupervisor_nip());
            name.setText(details.getSupervisor_name());
            department.setText(details.getSupervisor_department_name());
            department_initial.setText("(" + details.getSupervisor_department_initial() + ")");
            email.setText(details.getSupervisor_email());
            phone.setText(details.getSupervisor_phone());
            line.setText(details.getSupervisor_line());
            if (details.getSupervisor_gender().equalsIgnoreCase("m")) {
                gender.setText(R.string.gender_male);
            } else {
                gender.setText(R.string.gender_female);
            }
            getView().findViewById(R.id.batch_txt).setVisibility(View.GONE);
            getView().findViewById(R.id.divider4).setVisibility(View.GONE);
            getView().findViewById(R.id.profile_hour_inc).setVisibility(View.GONE);
        }
    };

    private Observer<List<Task>> observeCompletedViewModel = tasks -> {
        if(tasks != null){
            Log.d("TaskChecking", String.valueOf(tasks.size()));
            for (Task task:tasks
                 ) {
                timeCompleted += task.getTask_duration();
            }
            Log.d("TimeCompleted", String.valueOf(timeCompleted));
            completed.setText(Float.toString(timeCompleted));
        } else {

        }
    };


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

    private void loading(Boolean state) {
        if (state) {
            loading.setVisibility(View.VISIBLE);
        } else {
            loading.setVisibility(View.GONE);
        }
    }


}