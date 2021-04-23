package com.example.filmictionary;

public class Movie {
    private String mTitle;
    private String mImageUrl;
    private String mReleaseDate;
    private String mCast;
    private Double mImdbRatings;

    public Movie(String title, String imageUrl, String releaseDate, String cast, Double imdbRatings){
        mTitle = title;
        mImageUrl = imageUrl;
        mReleaseDate = releaseDate;
        mCast = cast;
        mImdbRatings = imdbRatings;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public String getmCast() {
        return mCast;
    }

    public Double getmImdbRatings() {
        return mImdbRatings;
    }
}
