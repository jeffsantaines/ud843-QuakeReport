package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jeff on 27-Aug-17.
 */

public class Earthquake {

    private String magnitude;
    private String location;
    private String date;
    private String time;

    public Earthquake(String magnitude, String location, String date, String time) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }


    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    //converts unix time in milliseconds to a SimpleDateFormat for example "Jan 25, 2014"
    public String getDate() {

        long long_date = Long.valueOf(this.date);
        Date dateObject = new Date(long_date);

        //Then we can initialize a SimpleDateFormat instance and configure it to provide a more //readable representation according to the given format.
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        return dateToDisplay;

    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {

        long long_time = Long.valueOf(this.date);
        Date dateObject = new Date(long_time);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("h:m:s a");
        String timeToDisplay = dateFormatter.format(dateObject);

        return timeToDisplay;
    }

    public void setTime(String time) {
        this.time = time;
    }
}