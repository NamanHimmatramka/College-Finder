package com.example.collegefinder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TopCollegeAdapterRV extends RecyclerView.Adapter<TopCollegeViewHolder> {
    ArrayList<College> colleges;
    Context ctx;
    public TopCollegeAdapterRV(ArrayList<College> colleges, Context ctx){
        this.colleges = colleges;
        this.ctx =ctx;
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
        holder.collegeName.setText(colleges.get(position).name);
        Glide.with(holder.collegeImage.getContext()).load(colleges.get(position).imgUrl).into(holder.collegeImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, CollegeInfoActivity.class);
                intent.putExtra("object", colleges.get(position));


            }
        });
        Intent intent = new Intent();

    }

    @Override
    public int getItemCount() {
        return colleges.size();
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
