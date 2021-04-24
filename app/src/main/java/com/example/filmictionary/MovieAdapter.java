package com.example.filmictionary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MovieAdapter extends ArrayAdapter<Movie> {


    public MovieAdapter(@NonNull Context context, List<Movie> movies) {
        super(context, 0, movies);

    }

    private int getratingColor(double rating){
        int ratingColorResourceId;
        int ratingFloor = (int)Math.floor(rating);
        switch (ratingFloor) {
            case 0:
            case 1:
                ratingColorResourceId = R.color.rating1;
                break;
            case 2:
                ratingColorResourceId = R.color.rating2;
                break;
            case 3:
                ratingColorResourceId = R.color.rating3;
                break;
            case 4:
                ratingColorResourceId = R.color.rating4;
                break;
            case 5:
                ratingColorResourceId = R.color.rating5;
                break;
            case 6:
                ratingColorResourceId = R.color.rating6;
                break;
            case 7:
                ratingColorResourceId = R.color.rating7;
                break;
            case 8:
                ratingColorResourceId = R.color.rating8;
                break;
            case 9:
                ratingColorResourceId = R.color.rating9;
                break;
            default:
                ratingColorResourceId = R.color.rating10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), ratingColorResourceId);
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
        releaseDateView.setText("release date: "+currentMovie.getmReleaseDate());

        TextView imdbRatingsView = (TextView) listItemView.findViewById(R.id.ratings);
        imdbRatingsView.setText(currentMovie.getmImdbRatings().toString());

        GradientDrawable ratingsCircle = (GradientDrawable) imdbRatingsView.getBackground();
        int magnitudeColor = getratingColor(currentMovie.getmImdbRatings());
        ratingsCircle.setColor(magnitudeColor);


//        TextView castView = (TextView) listItemView.findViewById(R.id.cast);
//        castView.setText(currentMovie.getmCast().toString());

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
          class ImageLoadTask extends AsyncTask<Void, Void, Bitmap>{
                private String url;
                private ImageView imageview;
                public ImageLoadTask(String url, ImageView imageView){
                    this.url = url;
                    this.imageview = imageView;

                }
                @Override
                protected Bitmap doInBackground(Void... params){
                    try{
                        Bitmap myBitmap;
                        URL connection = new URL(url);
                        InputStream input = connection.openStream();
                        myBitmap = BitmapFactory.decodeStream(input);
                        Bitmap resized = Bitmap.createScaledBitmap(myBitmap,1000,1000,true);
                        return resized;

                    }
                    catch (Exception e){

                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Bitmap result){
                    super.onPostExecute(result);
                    imageView.setImageBitmap(result);
                }

          }

          ImageLoadTask obj = new ImageLoadTask(currentMovie.getmImageUrl(),imageView);
          obj.execute();

        return listItemView;
    }
}
