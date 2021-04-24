package com.example.filmictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.URL;

public class Plot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plot);

        String storyline = getIntent().getStringExtra("storyline");
        String imageurl = getIntent().getStringExtra("imageurl");
        String castString = getIntent().getStringExtra("castString");

        TextView storyView = (TextView)findViewById(R.id.story);
        storyView.setText(storyline);

        TextView castView = (TextView) findViewById(R.id.cast);
        castView.setText(castString);

        ImageView image2View = (ImageView)findViewById(R.id.image2);


        class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {
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
                image2View.setImageBitmap(result);
            }

        }

        ImageLoadTask obj = new ImageLoadTask(imageurl,image2View);
        obj.execute();

    }
}