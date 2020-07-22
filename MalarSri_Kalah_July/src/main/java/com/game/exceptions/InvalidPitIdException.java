package com.game.exceptions;

public class InvalidPitIdException extends Exception {
    protected final String code = "GameIdNotFound";

    public InvalidPitIdException(String pitId) {
        super("Invalid pit id :" + pitId);
    }
}
