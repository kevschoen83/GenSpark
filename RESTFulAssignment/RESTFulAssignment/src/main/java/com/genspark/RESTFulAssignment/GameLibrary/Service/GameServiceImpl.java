package com.genspark.RESTFulAssignment.GameLibrary.Service;

import com.genspark.RESTFulAssignment.GameLibrary.Dao.GameDao;
import com.genspark.RESTFulAssignment.GameLibrary.Entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;

    @Override
    public List<Game> getAllGames() {
        return this.gameDao.findAll();
    }

    @Override
    public Game getGameById(int gameId) {
        Optional<Game> g = this.gameDao.findById(gameId);
        Game game = null;

        if (g.isPresent()) {
            game = g.get();
        } else {
            throw new RuntimeException(" Course not found for id :: " + gameId);
        }

        return game;
    }

    @Override
    public Game addGame(Game game) {
        return this.gameDao.save(game);
    }

    @Override
    public Game updateGame(Game game) {
        return this.gameDao.save(game);
    }

    @Override
    public String deleteGameById(int gameId) {
        this.gameDao.deleteById(gameId);
        return "Game deleted successfully";
    }
}
