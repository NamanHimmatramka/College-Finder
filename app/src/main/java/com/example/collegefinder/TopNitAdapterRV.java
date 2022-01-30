package com.example.collegefinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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
        holder.collegeName.setText(colleges.get(position).name);
        Glide.with(holder.collegeImage.getContext()).load(colleges.get(position*2).imgUrl).into(holder.collegeImage);
    }

    @Override
    public int getItemCount() {
        return 8;
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
