package com.genspark.movies.Service;

import com.genspark.movies.Dao.MoviesDao;
import com.genspark.movies.Entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesDao moviesDao;

    @Override
    public List<Movie> getAllMovies() {
        return this.moviesDao.findAll();
    }

    @Override
    public Movie getMovieById(int movieId) {
        Optional<Movie> m = this.moviesDao.findById(movieId);
        Movie movie = null;

        if (m.isPresent()) {
            movie = m.get();
        } else {
            throw new RuntimeException(" Course not found for id :: " + movieId);
        }

        return movie;
    }

    @Override
    public Movie addMovie(Movie movie) {
        return moviesDao.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return this.moviesDao.save(movie);
    }

    @Override
    public String deleteMovieById(int movieId) {
        this.moviesDao.deleteById(movieId);
        return "Movie deleted successfully";
    }

}
