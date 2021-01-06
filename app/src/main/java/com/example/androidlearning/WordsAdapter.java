package com.example.androidlearning;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class WordsAdapter extends ArrayAdapter<Word> {

    public WordsAdapter(@NonNull Context context, @NonNull ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
