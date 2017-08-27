package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jeff on 27-Aug-17.
 */

public class Earthquake {

    private double magnitude;
    private String location;
    private SimpleDateFormat date;

    public Earthquake(){
        this.magnitude = Double.parseDouble(null);
        this.location = null;
        this.date = null;
    }


    public Earthquake(double magnitude, String location, Date date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = new SimpleDateFormat();
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }



    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
