package com.example.collegefinder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class College implements Serializable {
    String name,imgUrl,info,website,hostel,city,state;
    long latitude,longitude;
    int nirf,fees,seats;
    double placementPercent;
    ArrayList<Course> courses;
    public College(String name, String imgUrl, String info, String website, String hostel, String city, String state, long latitude, long longitude, int nirf, int fees, int seats, double placementPercent, JSONArray courses){
        this.name = name;
        this.imgUrl=imgUrl;
        this.info=info;
        this.website=website;
        this.hostel=hostel;
        this.city=city;
        this.state=state;
        this.latitude=latitude;
        this.longitude=longitude;
        this.nirf=nirf;
        this.fees=fees;
        this.seats=seats;
        this.placementPercent=placementPercent;
        this.courses = new ArrayList<>();
        try {
            for (int i=0; i<=3; i++){
                JSONObject obj = courses.getJSONObject(i);
                Course course = new Course(obj.getString("coursename"), obj.getDouble("avgsal"), obj.getInt("cutoff1"), obj.getInt("cutoff2"));
                this.courses.add(course);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public College(String img, String img1, String name, String hostel, long latitude, String name1, String hostel1, int nirf, String img2, long longitude, int seats, String hostel2, String hostel3, String img3) {
//    }
}
