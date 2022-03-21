package com.example.food.views;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.food.R;
import com.example.food.models.Movie;
import com.squareup.picasso.Picasso;

public class MovieListItem extends RecyclerView.ViewHolder {
    private TextView textViewTitle, textViewYear, textViewGenre;
    private ImageView imageViewLogo;
    private Movie movie;

    private SQLiteDatabase db;

    public MovieListItem(View view) {
        super(view);
        textViewTitle = view.findViewById(R.id.textViewTitle);
        textViewGenre = view.findViewById(R.id.textViewGenre);
        textViewYear = view.findViewById(R.id.textViewYear);
        imageViewLogo = view.findViewById(R.id.imageViewLogo);
    }

    public Movie getMovie() {

        return movie;

    }

    public void setMovie(Movie movie) {
        this.movie = movie;
        //change DATA => Update UI
        //fetch Data to UI ? Yes
        textViewTitle.setText(movie.getTitle());
        textViewGenre.setText(movie.getGenre());
        textViewYear.setText(movie.getYear());
        Picasso.get()
                .load(movie.getUrl())
                .resize(120, 120)
                .centerCrop()
                .into(imageViewLogo);

    }
}