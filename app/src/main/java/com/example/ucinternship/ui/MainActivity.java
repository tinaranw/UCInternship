package com.example.ucinternship.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ucinternship.R;
import com.example.ucinternship.model.local.User;
import com.example.ucinternship.utils.SharedPreferenceHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private SharedPreferenceHelper helper;
    private String checkStudent, checkStaff, checkLecturer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this, MainActivity.this);

        checkStudent = "App'Models'Student";
        checkStaff = "App'Models'Staff";
        checkLecturer = "App'Models'Lecturer";

        BottomNavigationView navigationView = findViewById(R.id.main_navview);

        AppBarConfiguration configuration = new AppBarConfiguration
                .Builder(R.id.dashboardFragment, R.id.projectOfferFragment, R.id.projectListFragment, R.id.profileFragment)
                .build();

        navController = Navigation.findNavController(this, R.id.fragment);

        //check user's detailable
//        helper = SharedPreferenceHelper.getInstance(this);
//        if (helper.getRole().equalsIgnoreCase(checkStudent.replace("'", "\\\\"))) {
//            Log.d("checkstudent", "" + helper.getRole().equalsIgnoreCase(checkStudent.replace("'", "\\\\")));
//            navigationView.getMenu().findItem(R.id.projectOfferFragment).setVisible(true);
//        } else {
//            navigationView.getMenu().findItem(R.id.projectOfferFragment).setVisible(false);
//        }

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if(destination.getId() == R.id.dashboardFragment ||destination.getId() == R.id.projectOfferFragment || destination.getId() == R.id.projectListFragment || destination.getId() == R.id.profileFragment){
                navigationView.setVisibility(View.VISIBLE);

            }
            else {
                navigationView.setVisibility(View.GONE);
            }
        });

//        NavigationUI.setupActionBarWithNavController(this, navController, configuration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, (Openable) null);
    }

}