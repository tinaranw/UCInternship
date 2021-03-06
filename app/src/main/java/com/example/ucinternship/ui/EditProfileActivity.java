package com.example.ucinternship.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ucinternship.R;
import com.example.ucinternship.model.local.Info;
import com.example.ucinternship.model.local.Student;
import com.example.ucinternship.model.local.Supervisor;
import com.example.ucinternship.ui.viewmodel.LoginViewModel;
import com.example.ucinternship.ui.viewmodel.ProfileViewModel;
import com.example.ucinternship.utils.Constants;
import com.example.ucinternship.utils.SharedPreferenceHelper;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditProfileActivity extends AppCompatActivity implements TextWatcher {


    @BindView(R.id.edit_profilepic_img)
    ImageView image;

    @BindView(R.id.update_btn)
    Button update_btn;

    @BindView(R.id.phone_txtil)
    TextInputLayout phone_txtil;

    @BindView(R.id.line_txtil)
    TextInputLayout line_txtil;


    private ProfileViewModel viewModel;
    private SharedPreferenceHelper helper;
    private String checkStudent, checkStaff, checkLecturer, phone, line;
    FragmentManager fm = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ButterKnife.bind(this);
        checkStudent = "App'Models'Student";
        checkStaff = "App'Models'Staff";
        checkLecturer = "App'Models'Lecturer";

        viewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);
        helper = SharedPreferenceHelper.getInstance(this);
        viewModel.init(helper.getAccessToken());
        Log.d("tokeneditprofile", helper.getAccessToken());
        if (helper.getRole().equalsIgnoreCase(checkStudent.replace("'", "\\"))) {
            Log.d("checkstudent", "" + checkStudent.replace("'", "\\"));
            viewModel.getStudentDetails(helper.getUserID()).observe(this, observeStudentDetailViewModel);
        } else {
            viewModel.getSupervisorDetails(helper.getUserID()).observe(this, observeSupervisorDetailViewModel);
        }
        update_btn.setOnClickListener(v -> {
            update();
        });
        phone_txtil.getEditText().addTextChangedListener(this);
        line_txtil.getEditText().addTextChangedListener(this);

    }

    public void update() {
        if (!phone_txtil.getEditText().getText().toString().isEmpty() && !line_txtil.getEditText().getText().toString().isEmpty()) {
            String phone = phone_txtil.getEditText().getText().toString().trim();
            String line_account = line_txtil.getEditText().getText().toString().trim();
            if (helper.getRole().equalsIgnoreCase(checkStudent.replace("'", "\\"))) {
                viewModel.updateStudent(helper.getUserID(), phone, line_account).observe(this, tokenResponse -> {
                    if (tokenResponse != null) {
                        if (fm.getBackStackEntryCount() > 0) {
                            fm.popBackStack();
                        } else {
                            super.onBackPressed();
                        }
                        Toast.makeText(this, "Profile Updated.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed to Update Profile.", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                viewModel.updateSupervisor(helper.getUserID(), phone, line_account).observe(this, tokenResponse -> {
                    if (tokenResponse != null) {
                        if (fm.getBackStackEntryCount() > 0) {
                            fm.popBackStack();
                        } else {
                            super.onBackPressed();
                        }
                        Toast.makeText(this, "Profile Updated.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed to Update Profile.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    private final Observer<Student> observeStudentDetailViewModel = details -> {
        if (details != null) {
            Glide.with(this).load(Constants.BASE_IMAGE_URL + "student/" + details.getStudent_photo()).into(image);
            phone_txtil.getEditText().setText(details.getStudent_phone());
            line_txtil.getEditText().setText(details.getStudent_line());
        }
    };

    private final Observer<Supervisor> observeSupervisorDetailViewModel = details -> {
        if (details != null) {
            Glide.with(this).load(Constants.BASE_IMAGE_URL + "supervisor/" + details.getSupervisor_photo()).into(image);
            phone_txtil.getEditText().setText(details.getSupervisor_phone());
            line_txtil.getEditText().setText(details.getSupervisor_line());
        }
    };

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        phone = phone_txtil.getEditText().getText().toString().trim();
        line = line_txtil.getEditText().getText().toString().trim();

        if (!phone.isEmpty() && !line.isEmpty()) {
            update_btn.setEnabled(true);
        } else {
            update_btn.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}