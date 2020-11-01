package com.xo.model;

public class Game {

    private final Player[] players;
    private final Field field;

    public Game(Player[] players, Field field) {
        this.players = players;
        this.field = field;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

}
