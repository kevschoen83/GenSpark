package com.genspark.RESTFulAssignment.GameLibrary.Service;

import com.genspark.RESTFulAssignment.GameLibrary.Entity.Game;

import java.util.List;

public interface GameService {

    List<Game> getAllGames();
    Game getGameById(int gameId);
    Game addGame(Game game);
    Game updateGame(Game game);
    String deleteGameById(int gameId);

}
