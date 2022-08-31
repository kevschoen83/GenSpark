package com.genspark.movies.Service;

import com.genspark.movies.Entity.Movie;

import java.util.List;

public interface MoviesService {

    List<Movie> getAllMovies();
    Movie getMovieById(int movieId);
    Movie addMovie(Movie movie);
    Movie updateMovie(Movie movie);
    String deleteMovieById(int movieId);

}
