package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jeff on 30-Aug-17.
 */

public class EarthQuakeAdapter extends ArrayAdapter {

    public EarthQuakeAdapter(@NonNull Context context, @NonNull ArrayList<Earthquake> earthquakes) {
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

        TextView magnitude_textView = (TextView) listItemView.findViewById(R.id.magnitude_textView);
        magnitude_textView.setText(currentEarthquake.getMagnitude());

        TextView cityName_textView = (TextView) listItemView.findViewById(R.id.cityName_textView);
        cityName_textView.setText(currentEarthquake.getLocation());

        TextView date_textView = (TextView) listItemView.findViewById(R.id.date_textView);
        date_textView.setText(currentEarthquake.getDate());

        TextView time_textView = (TextView) listItemView.findViewById(R.id.time_textView);
        time_textView.setText(currentEarthquake.getTime());

        //Log.i("Earthquake Adapter", listItemView.toString());
        return listItemView;
    }

}
