package com.game.exceptions;

public class GameIdNotFoundException extends Exception {
    protected final String code = "GameIdNotFound";

    public GameIdNotFoundException(String gameId) {
        super("Game does not exist for id :" + gameId);
    }
}
