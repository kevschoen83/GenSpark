package com.genspark.GameLibrary.Service;

import com.genspark.GameLibrary.Entity.Game;

import java.util.List;

public interface GameService {

    List<Game> getAllGames();
    Game getGameById(int gameId);
    Game addGame(Game game);
    Game updateGame(Game game);
    String deleteGameById(int gameId);

}
