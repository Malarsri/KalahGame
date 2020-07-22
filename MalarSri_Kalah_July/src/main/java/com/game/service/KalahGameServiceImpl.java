package com.game.service;

import com.game.entities.Game;
import com.game.exceptions.GameIdNotFoundException;
import com.game.repository.StaticGameRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 Service implementation to create Kalah game
 */
@Service
@Qualifier("kalahGameServiceImpl")
public class KalahGameServiceImpl implements GameService {


    /**
     Method to load kalah game

     @return Game  - the Game details
     */
    @Override
    public Game createGame() {
        return StaticGameRepository.loadGame();
    }

    /**
     Method to load kalah game

     @param id -  the id of the game
     @return Game - the Game details
     */
    public Game loadGame(String id) throws GameIdNotFoundException {
        Optional<Game> gameOptional = Optional.of(StaticGameRepository.retrieveGame(id));
        if (!gameOptional.isPresent()) {
            throw new GameIdNotFoundException(id);
        }
        return gameOptional.get();
    }

    /**
     Method to update the kalah game

     @param game - the Game details
     */
    public void updateGame(Game game) {
        StaticGameRepository.updateGame(game);
    }
}
