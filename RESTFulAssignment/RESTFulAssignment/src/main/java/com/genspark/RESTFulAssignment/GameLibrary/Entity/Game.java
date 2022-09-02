package com.genspark.RESTFulAssignment.GameLibrary.Entity;

import javax.persistence.*;

@Entity
@Table(name="tbl_games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameId;

    private String title;
    private String year;
    private String developer;

    public Game() {
    }

    public Game(String title, String year, String developer) {
        this.title = title;
        this.year = year;
        this.developer = developer;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
}
