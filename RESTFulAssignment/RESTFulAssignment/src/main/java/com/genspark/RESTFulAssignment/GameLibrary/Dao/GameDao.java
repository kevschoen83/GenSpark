package com.genspark.RESTFulAssignment.GameLibrary.Dao;

import com.genspark.RESTFulAssignment.GameLibrary.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDao extends JpaRepository<Game, Integer> {
}
