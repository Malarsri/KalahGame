package com.game.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.entities.Game;
import com.game.entities.kalah.PitId;
import com.game.exceptions.GameIdNotFoundException;
import com.game.exceptions.InvalidPitIdException;
import com.game.model.GameInfo;
import com.game.service.KalahGameExecutorServiceImpl;
import com.game.service.KalahGameServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.game.model.GameInfo.map;

/**
 Controller Class which executes all the requirements for the game
 */
@Slf4j
@RestController
@RequestMapping("/kalah")
public class KalahGameController {

    private final KalahGameServiceImpl kalahGameServiceImpl;
    private final KalahGameExecutorServiceImpl kalahGameExecutorServiceImpl;

    @Autowired
    public KalahGameController(
            KalahGameServiceImpl kalahGameServiceImpl, KalahGameExecutorServiceImpl kalahGameExecutorServiceImpl) {
        this.kalahGameServiceImpl = kalahGameServiceImpl;
        this.kalahGameExecutorServiceImpl = kalahGameExecutorServiceImpl;
    }

    /**
     Method to create a new game

     @return facilitates with the values of GameInfo
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameInfo createGame() throws JsonProcessingException {
        log.info("Invoking create() endpoint... ");
        Game newGame = kalahGameServiceImpl.createGame();
        log.info("Game instance created. Id=" + newGame.getId());
        log.debug(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(newGame));
        return map(newGame);
    }

    /**
     Method to retrieve the GameInfo

     @param gameId - Unique Identifier of a game
     @return facilitates with the values of GameInfo
     */
    @GetMapping("/{gameId}")
    public GameInfo getGame(@PathVariable String gameId) throws GameIdNotFoundException {
        Game game = kalahGameServiceImpl.loadGame(gameId);
        return map(game);
    }

    /**
     Method to make a move in KalahGame

     @param gameId - Unique Identifier of a game
     @param pitId  - Pit id to be picked up for sowing
     @return facilitates with the values of GameInfo
     */
    @PutMapping(value = "games/{gameId}/pits/{pitId}")
    public GameInfo playGame(
            @PathVariable String gameId,
            @PathVariable int pitId) throws InvalidPitIdException, GameIdNotFoundException, JsonProcessingException {
        log.info("Invoking sow() endpoint. GameId: " + gameId + "  , pit Index: " + pitId);
        Game game = kalahGameServiceImpl.loadGame(gameId);
        Game updatedGame = kalahGameExecutorServiceImpl.execute(game, PitId.fromIntValue(pitId));
        kalahGameServiceImpl.updateGame(updatedGame);
        log.info("Invoking sow() endpoint. GameId: " + gameId + "  , pit Index: " + pitId);
        log.debug(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(updatedGame));
        return map(game);
    }
}
