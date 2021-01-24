package com.example.androidlearning;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

public final class QueryUtil {

    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5";

    public static final String LOG_TAG = QueryUtil.class.getSimpleName();

    private QueryUtil(){
        ;
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
        }
        return url;
    }


    static String fetchEarthquakeData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);
        Log.i(LOG_TAG, requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }

        // Return the {@link Event}
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String processDate(String dataFormat){

        long timeInMilliseconds = Long.getLong(dataFormat, 1);
        Date dateObject = new Date(timeInMilliseconds);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        return dateToDisplay;
    }

    public static ArrayList<QuakeData> extractEarthquakes(){

        ArrayList<QuakeData> earthquake = new ArrayList<QuakeData>();

        try {
//            JSONObject eqJson = new JSONObject(SAMPLE_JSON_RESPONSE);

            String jsonString = fetchEarthquakeData(USGS_REQUEST_URL);
            Log.i(LOG_TAG, jsonString);

            JSONObject eqJson = new JSONObject(jsonString);
            JSONArray eqValuesArray = eqJson.getJSONArray("features");
            for (int i = 0 ; i < eqValuesArray.length(); i++){
//                System.out.println(eqValuesArray.getJSONObject(i).getJSONObject("properties").toString());
                JSONObject tempJsonObject = eqValuesArray.getJSONObject(i).getJSONObject("properties");

                earthquake.add(new QuakeData(
                        tempJsonObject.getString("place"),
                        processDate(tempJsonObject.getString("time")),
                        tempJsonObject.getDouble("mag")
                ));

            }
        }
        catch (JSONException e){
            Log.e("","",e);
        }
        return earthquake;
    }

}
