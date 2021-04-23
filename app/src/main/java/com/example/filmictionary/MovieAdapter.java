package com.example.filmictionary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MovieAdapter extends ArrayAdapter<Movie> {


    public MovieAdapter(@NonNull Context context, List<Movie> movies) {
        super(context, 0, movies);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.movie_list_item, parent, false);
        }

        Movie currentMovie = getItem(position);

        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentMovie.getmTitle());

        TextView releaseDateView = (TextView) listItemView.findViewById(R.id.release_date);
        releaseDateView.setText(currentMovie.getmReleaseDate());

        TextView imdbRatingsView = (TextView) listItemView.findViewById(R.id.ratings);
        imdbRatingsView.setText(currentMovie.getmImdbRatings().toString());

        TextView castView = (TextView) listItemView.findViewById(R.id.cast);
        castView.setText(currentMovie.getmCast().toString());

        ImageView imageView = (ImageView)listItemView.findViewById(R.id.image_view);
//        URL url = null;
//        try {
//            url = new URL(currentMovie.getmImageUrl());
//            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            imageView.setImageBitmap(bmp);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        
        return listItemView;
    }
}
