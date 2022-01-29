package com.example.collegefinder;

public class Course {
    String courseName;
    double avgSal;
    int cutoff1,cutoff2;

    public Course(String courseName, double avgSal, int cutoff1, int cutoff2){
        this.courseName=courseName;
        this.avgSal=avgSal;
        this.cutoff1=cutoff1;
        this.cutoff2=cutoff2;
    }
}
