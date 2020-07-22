package com.game.service;

import com.game.entities.Game;
import com.game.entities.kalah.House;
import com.game.entities.kalah.Pit;
import com.game.entities.kalah.PitId;
import com.game.entities.kalah.PlayerId;
import com.game.exceptions.GameIdNotFoundException;
import com.game.testdata.GameTestData;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.game.testdata.GameTestData.createPit;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@RunWith(SpringRunner.class)
class KalahGameServiceImplTest {

    List<Pit> expectedPits = Arrays.asList(
            new Pit(PitId.ONE),
            new Pit(PitId.TWO),
            new Pit(PitId.THREE),
            new Pit(PitId.FOUR),
            new Pit(PitId.FIVE),
            new Pit(PitId.SIX)
    );
    House expectedHouse = new House();

    @Autowired
    private KalahGameServiceImpl kalahGameService;

    @Test
    void testCreatingNewGameInstance() {
        Game game = GameTestData.getFreshGame();
        Game createdGame = kalahGameService.createGame();
        BDDAssertions.then(createdGame.getId()).isNotNull();
        BDDAssertions.then(createdGame.getPlayerOne().getPits()).isEqualTo(expectedPits);
        BDDAssertions.then(createdGame.getPlayerOne().getHouse()).isEqualTo(expectedHouse);
        BDDAssertions.then(createdGame.getPlayerTwo().getPits()).isEqualTo(expectedPits);
        BDDAssertions.then(createdGame.getPlayerTwo().getHouse()).isEqualTo(expectedHouse);
        BDDAssertions.then(createdGame.getPlayerOne().playerId).isEqualTo(PlayerId.ONE);
        BDDAssertions.then(createdGame.getPlayerTwo().playerId).isEqualTo(PlayerId.TWO);
        BDDAssertions.then(createdGame.currentPlayer().playerId).isEqualTo(PlayerId.ONE);
    }

    @Test
    public void testLoadingGameInstanceFromRepository() throws GameIdNotFoundException {
        List<Pit> pitsOfPlayerOne = Arrays.asList(
                new Pit(PitId.ONE),
                createPit(PitId.TWO, 7),
                createPit(PitId.THREE, 7),
                createPit(PitId.FOUR, 7),
                createPit(PitId.FIVE, 7),
                createPit(PitId.SIX, 7)
        );
        House houseOfPlayerOne = new House();
        houseOfPlayerOne.setStones(1);
        Optional<Game> gameOptional = Optional.of(GameTestData.getOnGoingGame());
        Game fetchedGame = kalahGameService.loadGame("w24r43rd34d4353ft53");
        BDDAssertions.then(fetchedGame.getId()).isEqualTo("w24r43rd34d4353ft53");
        BDDAssertions.then(fetchedGame.getPlayerOne().getPits()).isEqualTo(pitsOfPlayerOne);
        BDDAssertions.then(fetchedGame.getPlayerOne().getHouse()).isEqualTo(houseOfPlayerOne);
        BDDAssertions.then(fetchedGame.getPlayerTwo().getPits()).isEqualTo(expectedPits);
        BDDAssertions.then(fetchedGame.getPlayerTwo().getHouse()).isEqualTo(expectedHouse);
        BDDAssertions.then(fetchedGame.getPlayerOne().playerId).isEqualTo(PlayerId.ONE);
        BDDAssertions.then(fetchedGame.getPlayerTwo().playerId).isEqualTo(PlayerId.TWO);
        BDDAssertions.then(fetchedGame.currentPlayer().playerId).isEqualTo(PlayerId.TWO);
    }

    @Test
    public void testUpdatingGameInstanceIntoRepository() throws Exception {

        List<Pit> pitsOfPlayerOne = Arrays.asList(
                new Pit(PitId.ONE),
                createPit(PitId.TWO, 7),
                createPit(PitId.THREE, 7),
                createPit(PitId.FOUR, 7),
                createPit(PitId.FIVE, 7),
                createPit(PitId.SIX, 7)
        );
        House houseOfPlayerOne = new House();
        houseOfPlayerOne.setStones(1);
        Game updatedGame = GameTestData.getOnGoingGame();
        kalahGameService.updateGame(updatedGame);
        BDDAssertions.then(updatedGame.getId()).isEqualTo("w24r43rd34d4353ft53");
        BDDAssertions.then(updatedGame.getPlayerOne().getPits()).isEqualTo(pitsOfPlayerOne);
        BDDAssertions.then(updatedGame.getPlayerOne().getHouse()).isEqualTo(houseOfPlayerOne);
        BDDAssertions.then(updatedGame.getPlayerTwo().getPits()).isEqualTo(expectedPits);
        BDDAssertions.then(updatedGame.getPlayerTwo().getHouse()).isEqualTo(expectedHouse);
        BDDAssertions.then(updatedGame.getPlayerOne().playerId).isEqualTo(PlayerId.ONE);
        BDDAssertions.then(updatedGame.getPlayerTwo().playerId).isEqualTo(PlayerId.TWO);
        BDDAssertions.then(updatedGame.currentPlayer().playerId).isEqualTo(PlayerId.TWO);
    }
}