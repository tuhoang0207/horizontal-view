package com.example.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.food.adapters.MoviesAdapter;
import com.example.food.database.moviesHelper;
import com.example.food.models.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> movieList = new ArrayList<>();
    private MoviesAdapter moviesAdapter;
    private RecyclerView recyclerViewMovie;

    private SQLiteDatabase db;

    moviesHelper moviesHelper;
    Cursor data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tao db
        moviesHelper = new moviesHelper(this,"movies.sqlite",null,1);

        //tao bang
        /*
        moviesHelper.QueryData("CREATE TABLE IF NOT EXISTS Movies(Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Title VARCHAR(200)," +
                "Genre VARCHAR(200)," +
                "Year VARCHAR(200)," +
                "Url VARCHAR(200))");

        moviesHelper.QueryData("INSERT INTO Movies VALUES (null,'spider man','sieu nhan','2000','https://www.facebook.com/images/fb_icon_325x325.png')");
        moviesHelper.QueryData("INSERT INTO Movies VALUES (null,'bad man','sieu nhan','2000','https://www.facebook.com/images/fb_icon_325x325.png')");
        moviesHelper.QueryData("INSERT INTO Movies VALUES (null,'bat man','sieu nhan','2000','https://www.facebook.com/images/fb_icon_325x325.png')");
         */

        //hien thi
        //tendb.sqlite3
        data = moviesHelper.GetData("SELECT * FROM Movies");
        while (data.moveToNext()) {
            String ten = data.getString(1);
            Toast.makeText(this,data.getString(1) , Toast.LENGTH_SHORT).show();
        }
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
        data = moviesHelper.GetData("SELECT * FROM Movies");
        while (data.moveToNext()) {
            movieList.add(new Movie(
                    data.getString(1),
                    data.getString(2),
                    data.getString(3),
                    data.getString(4)));

//        movieList.add(new Movie(
//                "cuộc đời tôi",
//                "Action & Adventure",
//                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Cat-MaineCoon-Cookie.png/253px-Cat-MaineCoon-Cookie.png"));
//        movieList.add(new Movie(
//                "Mad Max: Fury Road",
//                "Action & Adventure",
//                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Cat-MaineCoon-Cookie.png/253px-Cat-MaineCoon-Cookie.png"));
//        movieList.add(new Movie(
//                "Mad Max: Fury Road",
//                "Action & Adventure",
//                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
//        movieList.add(new Movie(
//                "Mad Max: Fury Road",
//                "Action & Adventure",
//                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
//        movieList.add(new Movie(
//                "Mad Max: Fury Road",
//                "Action & Adventure",
//                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
//        movieList.add(new Movie(
//                "Mad Max: Fury Road",
//                "Action & Adventure",
//                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));
//        movieList.add(new Movie(
//                "Mad Max: Fury Road",
//                "Action & Adventure",
//                "2015", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Maltese_puppy_blue_bow.jpg/200px-Maltese_puppy_blue_bow.jpg"));

            moviesAdapter.notifyDataSetChanged();
        }


    }
}