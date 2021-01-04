package com.example.androidlearning;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MultiScreen extends AppCompatActivity {

    //Global Variables
    String tag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // Executed when on App is opened.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_screen_master);
        tag = getString(R.string.log_tag);
        Log.i(tag, getString(R.string.log_on_create));
    }
}
