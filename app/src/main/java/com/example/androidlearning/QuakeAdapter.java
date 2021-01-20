package com.example.androidlearning;

import android.content.Context;
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

        TextView text1 = listItemView.findViewById(R.id.magnitude);
        text1.setText(String.valueOf(currentQuake.getMagnitude()));

        TextView text2 = listItemView.findViewById(R.id.city);
        text2.setText(currentQuake.getCity());

        TextView text3 = listItemView.findViewById(R.id.date);
        text3.setText(currentQuake.getDate());

        return listItemView;
    }
}
