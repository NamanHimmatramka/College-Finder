package com.example.collegefinder;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CollegeInfoFragment extends Fragment {

    College college;
    TextView textView;

    public CollegeInfoFragment() {
        // Required empty public constructor
    }

    public CollegeInfoFragment(College college){
        this.college = college;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_college_info, container, false);
        textView = view.findViewById(R.id.city_state);

        textView.setText(college.city);

        return view;
    }
}