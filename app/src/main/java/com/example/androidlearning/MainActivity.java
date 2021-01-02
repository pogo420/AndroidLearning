package com.example.androidlearning;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    String tag = "SampleDemo:";
//    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.birthday_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        Log.i(tag, "--onCreate--");
//        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag, "--onStart--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag, "--onStop--");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag, "--onDestroy--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag, "--onResume--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(tag, "--onRestart--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag, "--onPause--");
    }
//    public void clickHandler(View view){
//        textView.setText("Hello Android");
//        Toast.makeText(this, "Clicked a button",Toast.LENGTH_LONG).show();
//    }
}