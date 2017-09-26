package com.example.android.quakereport;
import android.content.AsyncTaskLoader;
import android.content.Context;
import java.util.List;

/**
 * Created by Jeff on 22-Sep-17.
 */
public class EarthquakeTaskLoader extends AsyncTaskLoader<List<Earthquake>> {

   // private static final String LOG_TAG = EarthquakeTaskLoader.class.getName();
    private String mUrl;

    public EarthquakeTaskLoader(Context context, String url) {
        super(context);
        mUrl = url;

    }

    @Override
    protected void onStartLoading() {

        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (mUrl == null) {
            return  null;
        }

        List<Earthquake> earthquakes = QueryUtils.extractEarthquakes(mUrl);
        return earthquakes;
    }

}
