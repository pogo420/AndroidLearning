package com.example.androidlearning;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class EarthquakeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

//        // Create a fake list of earthquake locations.
//        ArrayList<String> earthquakes = new ArrayList<>();
//        earthquakes.add("San Francisco");
//        earthquakes.add("London");
//        earthquakes.add("Tokyo");
//        earthquakes.add("Mexico City");
//        earthquakes.add("Moscow");
//        earthquakes.add("Rio de Janeiro");
//        earthquakes.add("Paris");

//        ArrayList<QuakeData> earthquakes = new ArrayList<>();
//
//        earthquakes.add(new QuakeData("Kolkata", "25-02-2021", 5.90));
//        earthquakes.add(new QuakeData("Kolkata", "25-02-2021", 5.90));
//        earthquakes.add(new QuakeData("Kolkata", "25-02-2021", 5.90));
//        earthquakes.add(new QuakeData("Kolkata", "25-02-2021", 5.90));
//        earthquakes.add(new QuakeData("Kolkata", "25-02-2021", 5.90));

        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute();
//        ArrayList<QuakeData> earthquakes = QueryUtil.extractEarthquakes();

    }

    private class EarthquakeAsyncTask extends AsyncTask<Void, Void, ArrayList<QuakeData> > {
        // inner class for async operation will be depcicated in future.

        @Override
        protected ArrayList<QuakeData>  doInBackground(Void... voids) {
            ArrayList<QuakeData>  result = QueryUtil.extractEarthquakes();
            return result;
        }

        protected void onPostExecute(ArrayList<QuakeData> result) {
            // If there is no result, do nothing.
            if (result == null) {
                return;
            }

            updateAdapter(result);
        }
    }

    private void updateAdapter(ArrayList<QuakeData> earthquakes) {

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

//        // Create a new {@link ArrayAdapter} of earthquakes
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, R.layout.eq_rows, earthquakes);

        QuakeAdapter adapter = new QuakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                QuakeData quakeData = earthquakes.get(position);
                System.out.println(quakeData.getCity());
            }
        });

    }

}