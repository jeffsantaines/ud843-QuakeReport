package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.graphics.drawable.GradientDrawable;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff on 30-Aug-17.
 */

public class EarthQuakeAdapter extends ArrayAdapter {

    public EarthQuakeAdapter(@NonNull Context context, @NonNull List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = (Earthquake) getItem(position);
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output_Magnitude = formatter.format((currentEarthquake.getMagnitude()));


        TextView magnitude_textView = (TextView) listItemView.findViewById(R.id.magnitude_textView);
        magnitude_textView.setText(output_Magnitude);


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView "magnitude_textView from our list_item.xml file, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude_textView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude which we will use to set the colour of our magnitude cirle
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        String currentLocation;
        currentLocation = currentEarthquake.getLocation();
        String offsetLocationForTextView = getOffsetLocation(currentLocation);
        String primaryLocationForTextView = getPrimaryLocation(currentLocation);


        TextView locationOffset_textView = (TextView) listItemView.findViewById(R.id.locationOffset_textView);
        locationOffset_textView.setText(offsetLocationForTextView);


        TextView cityName_textView = (TextView) listItemView.findViewById(R.id.cityName_textView);
        cityName_textView.setText(primaryLocationForTextView);

        TextView date_textView = (TextView) listItemView.findViewById(R.id.date_textView);
        date_textView.setText(currentEarthquake.getDate());

        TextView time_textView = (TextView) listItemView.findViewById(R.id.time_textView);
        time_textView.setText(currentEarthquake.getTime());

        //Log.i("Earthquake Adapter", listItemView.toString());
        return listItemView;
    }

    int additionalCharacters = 3;  ///additional characters after the "of" string

    private String getOffsetLocation(String currentLocation) {
        int index = currentLocation.indexOf("of");
        String offsetLocation;
        if (index > 0){
             offsetLocation = currentLocation.substring(0, index + additionalCharacters);
        }
        else {
            offsetLocation = getContext().getString(R.string.default_offsetLocation);
        }
        Log.e("EarthquakeAdapter", offsetLocation);
        return offsetLocation;


    }

    private String getPrimaryLocation( String currentLocation){
        int index = currentLocation.indexOf("of");
        String primaryLocation;
        if (index>0) {
             primaryLocation = currentLocation.substring(index + additionalCharacters, currentLocation.length());
        }
        else {
            primaryLocation = currentLocation;
        }
        Log.e("EarthquakeAdapter", primaryLocation);

        return primaryLocation;
    }

    //returns the id of the appropriate colour depending on the magnitude of the earthquake

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }




}
