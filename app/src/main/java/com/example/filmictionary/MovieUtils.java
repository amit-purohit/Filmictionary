package com.example.filmictionary;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public final class MovieUtils {

    private MovieUtils() {
    }

    public static ArrayList<Movie> extractMovies(){

        ArrayList<Movie> movies = new ArrayList<Movie>();

        try{
            JSONObject baseJsonResponse = new JSONObject(BollywoodJson.y);
            JSONArray movieArray = baseJsonResponse.getJSONArray("main");

            for(int i=0; i<movieArray.length(); i++){
                JSONObject currentMovie = movieArray.getJSONObject(i);
                String title = currentMovie.getString("title");
                String imageUrl = currentMovie.getString("posterurl");
                String releaseDate = currentMovie.getString("releaseDate");
                Double imdbRatings = currentMovie.getDouble("imdbRating");
                String storyLine = currentMovie.getString("storyline");
                JSONArray castArray = currentMovie.getJSONArray("actors");
                String cast="";
                for(int j=0;j<castArray.length();j++){
                    cast += "-> " + castArray.getString(j) + "\n";
                }
                Movie movie = new Movie(title, imageUrl, releaseDate, cast, imdbRatings,storyLine);
                movies.add(movie);


            }






        }
        catch(JSONException e){


        }

        return movies;

    }

}
