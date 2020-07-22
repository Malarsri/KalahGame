package com.game.service;

import com.game.entities.Game;
import com.game.exceptions.GameIdNotFoundException;
import com.game.exceptions.InvalidPitIdException;

public interface GameService {

    Game createGame();

    Game loadGame(String id) throws InvalidPitIdException, GameIdNotFoundException;

    void updateGame(Game game);
}
