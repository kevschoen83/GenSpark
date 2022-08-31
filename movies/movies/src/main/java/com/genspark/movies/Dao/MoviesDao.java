package com.genspark.movies.Dao;

import com.genspark.movies.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesDao extends JpaRepository<Movie, Integer> {
}
