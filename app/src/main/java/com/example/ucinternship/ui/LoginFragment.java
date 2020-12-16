package com.example.ucinternship.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.ucinternship.R;
import com.example.ucinternship.model.response.TokenResponse;
import com.example.ucinternship.ui.login.LoginViewModel;
import com.example.ucinternship.utils.SharedPreferenceHelper;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {

    @BindView(R.id.login_btn)
    Button login_btn;

    @BindView(R.id.password_inp)
    TextInputLayout password_inp;

    @BindView(R.id.email_inp)
    TextInputLayout email_inp;

    private LoginViewModel viewModel;
    private SharedPreferenceHelper helper;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        viewModel = ViewModelProviders.of(requireActivity()).get(LoginViewModel.class);
        helper =  SharedPreferenceHelper.getInstance(requireActivity());

        login_btn.setOnClickListener(v -> {
            Login(view);
        });
    }

    public void Login(View view){
        if(!email_inp.getEditText().getText().toString().isEmpty() && !password_inp.getEditText().getText().toString().isEmpty()){
            String email = email_inp.getEditText().getText().toString().trim();
            Log.d("user-email", email);
            String password = password_inp.getEditText().getText().toString().trim();
            Log.d("user-password", password);
            viewModel.login(email, password).observe(requireActivity(), tokenResponse -> {
                if(tokenResponse != null){
                    helper.saveAccessToken(tokenResponse.getAuthorization());
                    NavDirections actions = LoginFragmentDirections.actionLoginFragmentToDashboardFragment();
                    Navigation.findNavController(view).navigate(actions);
                    Toast.makeText(requireActivity(),  "Success", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}