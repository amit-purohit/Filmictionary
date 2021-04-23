package com.example.filmictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.usage.UsageEvents;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Movie> movies = MovieUtils.extractMovies();

        ListView movieListView = (ListView) findViewById(R.id.list);

        final MovieAdapter adapter = new MovieAdapter(this, movies);

        movieListView.setAdapter(adapter);




    }



}