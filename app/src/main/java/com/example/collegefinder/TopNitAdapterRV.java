package com.example.collegefinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopNitAdapterRV extends RecyclerView.Adapter<TopNitViewHolder> {

    ArrayList<College> colleges;
    public TopNitAdapterRV(ArrayList<College> colleges){
        this.colleges = colleges;
    }
    @NonNull
    @Override
    public TopNitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        TopNitViewHolder viewHolder = new TopNitViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TopNitViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class TopNitViewHolder extends RecyclerView.ViewHolder{

    ImageView collegeImage;
    TextView collegeName;

    public TopNitViewHolder(@NonNull View itemView) {
        super(itemView);

        collegeImage = itemView.findViewById(R.id.college_image);
        collegeName = itemView.findViewById(R.id.college_name);
    }
}
