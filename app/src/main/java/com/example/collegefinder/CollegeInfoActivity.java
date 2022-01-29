package com.example.collegefinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CollegeInfoActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_info);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.info:
                        getSupportFragmentManager().beginTransaction().replace(R.id.college_info_frame_layout, new CollegeInfoFragment()).commit();
                        return true;

                    case R.id.map:
                        getSupportFragmentManager().beginTransaction().replace(R.id.college_info_frame_layout, new CollegeMapFragment()).commit();
                        return true;
                }


                return false;
            }
        });
    }
}