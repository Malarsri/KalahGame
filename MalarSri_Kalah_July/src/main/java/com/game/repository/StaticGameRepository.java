package com.game.repository;

import com.game.entities.Game;
import org.springframework.util.SimpleIdGenerator;

import java.util.HashMap;
import java.util.Map;

public class StaticGameRepository {

    public static Map<String, Game> gameMap = new HashMap<>();
    static SimpleIdGenerator idGenerator = new SimpleIdGenerator();

    public static Game loadGame() {
        String gameId = idGenerator.generateId().toString();
        Game newGame = new Game(gameId);
        gameMap.put(gameId, newGame);
        return newGame;
    }

    public static Game retrieveGame(String gameId) {
        Game fetchedGame = gameMap.get(gameId);
        return fetchedGame;
    }

    public static Game updateGame(Game game) {
        gameMap.put(game.getId(), game);
        return game;
    }
}
