package com.example.ucinternship.ui.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ucinternship.R;
import com.example.ucinternship.ui.MainActivity;
import com.example.ucinternship.utils.SharedPreferenceHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashFragment extends Fragment {

    SharedPreferenceHelper sharedPreferenceHelper;

    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferenceHelper = new SharedPreferenceHelper(getActivity());
        Log.d("balalala", String.valueOf(sharedPreferenceHelper.getLogin()));
        if (sharedPreferenceHelper.getLogin()){
            NavDirections action = SplashFragmentDirections.actionSplashtoDashboard();
            Navigation.findNavController(view).navigate(action);
        }else{
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                NavDirections action = SplashFragmentDirections.actionSplashFragmentToLoginFragment();
                Navigation.findNavController(view).navigate(action);
            }, 2000);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
//        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }
}