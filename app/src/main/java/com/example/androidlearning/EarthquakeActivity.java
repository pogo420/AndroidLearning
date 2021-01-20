package com.example.androidlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

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

        ArrayList<QuakeData> earthquakes = new ArrayList<>();

        earthquakes.add(new QuakeData("Kolkata", "25-02-2021", (float) 5.90));
        earthquakes.add(new QuakeData("Kolkata", "25-02-2021", (float) 5.90));
        earthquakes.add(new QuakeData("Kolkata", "25-02-2021", (float) 5.90));
        earthquakes.add(new QuakeData("Kolkata", "25-02-2021", (float) 5.90));
        earthquakes.add(new QuakeData("Kolkata", "25-02-2021", (float) 5.90));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

//        // Create a new {@link ArrayAdapter} of earthquakes
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, R.layout.eq_rows, earthquakes);

        QuakeAdapter adapter = new QuakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
    
}