package com.genspark.movies.Controller;

import com.genspark.movies.Entity.Movie;
import com.genspark.movies.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/")
    public String home() {
        return "<HTML><H1>Welcome to my Movies Application!<H1></HTML>";
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return this.moviesService.getAllMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovie(@PathVariable String movieId) {
        return this.moviesService.getMovieById(Integer.parseInt(movieId));
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return this.moviesService.addMovie(movie);
    }

    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie movie) {
        return this.moviesService.updateMovie(movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public String deleteMovie(@PathVariable String movieId) {
        return this.moviesService.deleteMovieById(Integer.parseInt(movieId));
    }

}
