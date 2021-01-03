package com.example.androidlearning;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String tag = "SampleDemo:";
    int globalCount = 1;
    final int priceAnount = 10;
    final int creamPrice = 1;
    final int chocolatePrice = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinput_test);
//        setContentView(R.layout.hungry_layout);
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
        displayPrice(priceAnount*globalCount, false);
    }

    private void composeEmail(String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void reset(View view){
        globalCount=0;
        displayQuantity(globalCount);
        displayPrice(priceAnount*globalCount, true);
    }

    private void displayQuantity(int value){
        TextView quantitity = (TextView) findViewById(R.id.quantity_value);
        quantitity.setText("" + value);
    }
    private void displayPrice(int value, boolean reset){

        TextView quantitity = (TextView) findViewById(R.id.price_value);
        CheckBox wippedCream = (CheckBox) findViewById(R.id.wippedCream);
        CheckBox choc = (CheckBox) findViewById(R.id.chocolate);
        EditText name = (EditText) findViewById(R.id.name);
        String nameValue = name.getText().toString();

        String message = priceGenarator(value,nameValue,reset,wippedCream.isChecked(), choc.isChecked());
        if(reset){
            wippedCream.setChecked(false);
            choc.setChecked(false);
        }
        else {

            composeEmail("sample", message);
        }
//        quantitity.setText(message);
    }


    private String priceGenarator(int value,
                                  String name,
                                  boolean reset,
                                  boolean cream,
                                  boolean chocolate){

        String message;
        int totalAmount=value;

        if (cream){
            totalAmount+=creamPrice;
        }
        if (chocolate){
            totalAmount+=chocolatePrice;
        }

        if (!reset && value>0){
            message = String.format(
                           "Hello %s\n" +
                           "Total Price INR %d\n",
                    name, totalAmount
            );
        }
        else {
            message = String.format("Total Price INR %d\nThnak you!!", value);
        }

        return  message;

    }

    public void eatCookie(View view){
        ImageView image = (ImageView) findViewById(R.id.cookieImage);
        TextView cookie = (TextView) findViewById(R.id.cookieText);
        image.setImageResource(R.drawable.after_cookie);
        cookie.setText("I'm Full");
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