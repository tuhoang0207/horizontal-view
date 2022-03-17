package com.example.food.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.R;
import com.example.food.models.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private ArrayList<MovieModel> moviesList;
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, year, genre;
        ImageView logo;
        MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            genre = view.findViewById(R.id.genre);
            year = view.findViewById(R.id.year);
            logo = view.findViewById(R.id.logo);
        }
    }
    public MoviesAdapter(ArrayList<MovieModel> moviesList) {
        this.moviesList = moviesList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movies_list, parent, false);
        return new MyViewHolder(itemView);
    }

    String url = "https://www.facebook.com/images/fb_icon_325x325.png";
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MovieModel movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
//        holder.logo.setImageResource(R.drawable.ic_launcher_background);
    }
    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
