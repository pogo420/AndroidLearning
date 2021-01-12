package com.example.androidlearning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class WordsAdapter extends ArrayAdapter<Word> {

    public WordsAdapter(@NonNull Context context, @NonNull ArrayList<Word> words) {
        super(context, 0, words); // Second value can be anything as we are not going to use it
        // we are manually adding data to items so we wont set it.
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // this method is called for each data of array/ list

        View listItemView = convertView; // view of each item it will be reused.
        if(listItemView == null) { // if new then set it with view of item
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_text_layout, parent, false);
        }

        // getting current value
        Word currentWord = getItem(position); // each data

        TextView text1 = listItemView.findViewById(R.id.eng);
        text1.setText(currentWord.getEnglish());


        TextView text2 = listItemView.findViewById(R.id.mik);
        text2.setText(currentWord.getMeWok());


        ImageView image = listItemView.findViewById(R.id.word_image);

        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            image.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            image.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            image.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
