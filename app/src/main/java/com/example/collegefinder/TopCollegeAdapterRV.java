package com.example.collegefinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopCollegeAdapterRV extends RecyclerView.Adapter<TopCollegeViewHolder> {
    ArrayList<College> colleges;
    public TopCollegeAdapterRV(ArrayList<College> colleges){
        this.colleges = colleges;
    }
    @NonNull
    @Override
    public TopCollegeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        TopCollegeViewHolder viewHolder = new TopCollegeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TopCollegeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class TopCollegeViewHolder extends RecyclerView.ViewHolder{

    ImageView collegeImage;
    TextView collegeName;

    public TopCollegeViewHolder(@NonNull View itemView) {
        super(itemView);

        collegeImage = itemView.findViewById(R.id.college_image);
        collegeName = itemView.findViewById(R.id.college_name);
    }
}
