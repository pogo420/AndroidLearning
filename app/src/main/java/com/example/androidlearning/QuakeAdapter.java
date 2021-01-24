package com.example.androidlearning;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuakeAdapter extends ArrayAdapter<QuakeData> {

    public QuakeAdapter(@NonNull Context context, @NonNull ArrayList<QuakeData> quakeData) {
        super(context, 0, quakeData); // Second value can be anything as we are not going to use it
        // we are manually adding data to items so we wont set it.
    }

    private int getColorMagnitude(double magnitude){
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
        return magnitudeColorResourceId;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView; // view of each item it will be reused.
        if(listItemView == null) { // if new then set it with view of item
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_row, parent, false);  // layout is each element for list.
        }

        // getting current value
        QuakeData currentQuake = getItem(position); // each data

        // View 1
        TextView text1 = listItemView.findViewById(R.id.magnitude);
        text1.setText(String.valueOf(currentQuake.getMagnitude()));
        // Getting the background
        GradientDrawable magnitudeCircle = (GradientDrawable) text1.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getColorMagnitude(currentQuake.getMagnitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // View 2
        TextView text2 = listItemView.findViewById(R.id.city);
        text2.setText(currentQuake.getCity());

        // View 3
        TextView text3 = listItemView.findViewById(R.id.date);
        text3.setText(currentQuake.getDate());

        return listItemView;
    }
}
