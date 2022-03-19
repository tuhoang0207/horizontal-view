package com.example.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.food.adapters.MoviesAdapter;
import com.example.food.models.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> movieList = new ArrayList<>();
    private MoviesAdapter moviesAdapter;
    private RecyclerView recyclerViewMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMovie = findViewById(R.id.recyclerViewMovies);
        moviesAdapter = new MoviesAdapter(movieList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewMovie.setLayoutManager(mLayoutManager);
        recyclerViewMovie.setItemAnimator(new DefaultItemAnimator());
        prepareMovieData();
        recyclerViewMovie.setAdapter(moviesAdapter);
    }

    private void prepareMovieData() {
        movieList.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
        movieList.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Cat-MaineCoon-Cookie.png/253px-Cat-MaineCoon-Cookie.png"));
        movieList.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Cat-MaineCoon-Cookie.png/253px-Cat-MaineCoon-Cookie.png"));
        movieList.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
        movieList.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
        movieList.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
        movieList.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
        movieList.add(new Movie(
                "Mad Max: Fury Road",
                "Action & Adventure",
                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));

        moviesAdapter.notifyDataSetChanged();
    }
}