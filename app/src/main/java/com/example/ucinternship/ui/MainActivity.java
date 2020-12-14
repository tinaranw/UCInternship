package com.example.ucinternship.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.ucinternship.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
//    @BindView(R.id.main_toolbar)
//    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this, MainActivity.this);
//        setSupportActionBar(toolbar);

        BottomNavigationView navigationView = findViewById(R.id.main_navview);

        AppBarConfiguration configuration = new AppBarConfiguration
                .Builder(R.id.dashboardFragment, R.id.projectOfferFragment, R.id.projectListFragment, R.id.profileFragment)
                .build();

        navController = Navigation.findNavController(this, R.id.fragment);

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