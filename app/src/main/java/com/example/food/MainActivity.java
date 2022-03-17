package com.example.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.food.adapters.MoviesAdapter;
import com.example.food.models.MovieModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MovieModel> movieList = new ArrayList<>();
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        mAdapter = new MoviesAdapter(movieList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
    }

    private void prepareMovieData() {
        MovieModel movie1 = new MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015", "https://www.facebook.com/images/fb_icon_325x325.png");
        movieList.add(movie1);
        MovieModel movie2 = new MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015", "https://www.facebook.com/images/fb_icon_325x325.png");
        movieList.add(movie2);
        MovieModel movie3 = new MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015", "https://www.facebook.com/images/fb_icon_325x325.png");
        movieList.add(movie3);
        MovieModel movie4 = new MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015", "https://www.facebook.com/images/fb_icon_325x325.png");
        movieList.add(movie4);
        MovieModel movie5 = new MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015", "https://www.facebook.com/images/fb_icon_325x325.png");
        movieList.add(movie5);
        MovieModel movie6 = new MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015", "https://www.facebook.com/images/fb_icon_325x325.png");
        movieList.add(movie6);
        MovieModel movie7 = new MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015", "https://www.facebook.com/images/fb_icon_325x325.png");
        movieList.add(movie7);
        MovieModel movie8 = new MovieModel("Mad Max: Fury Road", "Action & Adventure", "2015", "https://www.facebook.com/images/fb_icon_325x325.png");
        movieList.add(movie8);

        mAdapter.notifyDataSetChanged();
    }
}