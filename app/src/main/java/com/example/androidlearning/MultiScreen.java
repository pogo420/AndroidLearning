package com.example.androidlearning;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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

    public void handleNumbers(View view){
        // running self activity as intent
        startActivity(new Intent(this, NumbersActivity.class));
//        Toast.makeText(this,R.string.category_numbers,
//                Toast.LENGTH_SHORT).show();
    }

    public void handleFamily(View view){
        // running self activity as intent
        startActivity(new Intent(this, FamilyActivity.class));
    }

    public void handleColours(View view){
        // running self activity as intent
        startActivity(new Intent(this, ColoursActivity.class));
    }

    public void handlePhrases(View view){
        // running self activity as intent
        startActivity(new Intent(this, PhrasesActivity.class));
    }

}
