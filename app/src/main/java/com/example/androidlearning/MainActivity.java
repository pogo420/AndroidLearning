package com.example.androidlearning;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String tag = "SampleDemo:";
    int globalCount = 1;
    int priceAnount = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.userinput_test);
        setContentView(R.layout.userinput_test);
        Log.i(tag, "--onCreate--");
    }

    public void increaseOrder(View view){
        globalCount++;
        displayQuantity(globalCount);
//        displayPrice(priceAnount*globalCount);
    }

    public void decreaseOrder(View view){
        globalCount--;
        displayQuantity(globalCount);
//        displayPrice(priceAnount*globalCount);
    }
    public void submitOrder(View view){
        displayPrice(priceAnount*globalCount);
    }

    public void reset(View view){
        globalCount=0;
        displayQuantity(globalCount);
        displayPrice(priceAnount*globalCount);
    }

    private void displayQuantity(int value){
        TextView quantitity = (TextView) findViewById(R.id.quantity_value);
        quantitity.setText("" + value);
    }
    private void displayPrice(int value){
        TextView quantitity = (TextView) findViewById(R.id.price_value);

        String message = String.format("Total Price INR %d\nThnak you!!", value);
        quantitity.setText(message);
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
}