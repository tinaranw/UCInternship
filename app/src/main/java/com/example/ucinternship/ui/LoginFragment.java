package com.example.ucinternship.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
import com.example.ucinternship.ui.viewmodel.LoginViewModel;
import com.example.ucinternship.utils.SharedPreferenceHelper;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginFragment extends Fragment {

    @BindView(R.id.login_btn)
    Button login_btn;

    @BindView(R.id.password_inp)
    TextInputLayout password_inp;

    @BindView(R.id.email_inp)
    TextInputLayout email_inp;

    private LoginViewModel viewModel;
    private SharedPreferenceHelper helper, helperUserID, helperRole;

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

        //inisialisasi viewmodel dan sharedpref
        viewModel = ViewModelProviders.of(requireActivity()).get(LoginViewModel.class);
        helper =  SharedPreferenceHelper.getInstance(requireActivity());
        helperUserID =  SharedPreferenceHelper.getInstance(requireActivity());
        helperRole =  SharedPreferenceHelper.getInstance(requireActivity());

        login_btn.setOnClickListener(v -> {
            //ngecek klo misal ada user maka di lempar ke dash langsung sedangkan klo g ada masuk login (splashfragment)
            helper.saveSPBoolean(SharedPreferenceHelper.LOGIN, true);
            Login(view);
        });
    }

    //View view ini untuk navigation (nav)
    public void Login(View view){
        //krn ada input email dan pass, kita hrs get data yang ada disini
        if(!email_inp.getEditText().getText().toString().isEmpty() && !password_inp.getEditText().getText().toString().isEmpty()){
            String email = email_inp.getEditText().getText().toString().trim();
            Log.d("user-email", email);
            String password = password_inp.getEditText().getText().toString().trim();
            Log.d("user-password", password);
            //email dan pass berupa string
            viewModel.login(email, password).observe(requireActivity(), tokenResponse -> {
                // klo dah dpt token maka ia akan diarahkan ke nav dan nge save token nya di sharedpref
                if(tokenResponse != null){
                    helper.saveAccessToken(tokenResponse.getAuthorization());
                    helperUserID.saveUserID(tokenResponse.getUser_id());
                    helperRole.saveRole(tokenResponse.getRole());
                    Log.d("anjingras", ""+tokenResponse.getRole());
                    Log.d("anjingr", ""+helperRole.getRole());
                    Log.d("anjing", ""+helperUserID.getUserID());
                    NavDirections actions = LoginFragmentDirections.actionLoginFragmentToDashboardFragment();
                    Navigation.findNavController(view).navigate(actions);
                    Toast.makeText(requireActivity(),  "Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(requireActivity(),  "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}