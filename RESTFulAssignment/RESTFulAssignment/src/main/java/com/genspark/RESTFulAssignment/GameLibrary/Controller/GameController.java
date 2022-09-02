package com.genspark.RESTFulAssignment.GameLibrary.Controller;

import com.genspark.RESTFulAssignment.GameLibrary.Entity.Game;
import com.genspark.RESTFulAssignment.GameLibrary.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String home() {
        return "<HTML><H1>Welcome to Game Application</H1></HTML>";
    }

    @GetMapping("/games")
    public List<Game> getGames() {
        return this.gameService.getAllGames();
    }

    @GetMapping("/games/{gameId}")
    public Game getGame(@PathVariable String gameId) {
        return this.gameService.getGameById(Integer.parseInt(gameId));
    }

    @PostMapping("/games")
    public Game addGame(@RequestBody Game game) {
        return this.gameService.addGame(game);
    }

    @PutMapping("/games")
    public Game updateGame(@RequestBody Game game) {
        return this.gameService.updateGame(game);
    }

    @DeleteMapping("/games/{gameId}")
    public String deleteGame(@PathVariable String gameId) {
        return this.gameService.deleteGameById(Integer.parseInt(gameId));
    }

}
