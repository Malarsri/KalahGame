package com.game.service;

import com.game.entities.Game;
import com.game.entities.kalah.Pit;
import com.game.entities.kalah.PitId;
import com.game.entities.kalah.PlayerId;
import com.game.exceptions.InvalidPitIdException;
import com.game.testdata.GameTestData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static com.game.testdata.GameTestData.createPit;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@RunWith(SpringRunner.class)
class KalahGameExecutorServiceImplTest {
    @Autowired
    private KalahGameExecutorServiceImpl kalahGameExecutorService;

    @Test
    public void testSequenceOfMultipleSow() throws InvalidPitIdException {
        Game game = GameTestData.getFreshGame();
        //SowOfSecondPitPlayerONE -> Result [1:6, 2:0, 3:7, 4:7, 5:7, 6:7, 7:1, 8:7, 9:6, 10:6, 11:6, 12:6, 13:6, 14:0]
        game = kalahGameExecutorService.execute(game, PitId.TWO);
        List<Pit> playerOnePits = game.getPlayerOne().getPits();
        List<Pit> playerTwoPits = game.getPlayerTwo().getPits();
        Assertions.assertThat(playerOnePits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 6),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 7),
                createPit(PitId.FOUR, 7),
                createPit(PitId.FIVE, 7),
                createPit(PitId.SIX, 7)
        ));
        Assertions.assertThat(game.getPlayerOne().getHouse().getStones()).isEqualTo(1);
        Assertions.assertThat(playerTwoPits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 7),
                createPit(PitId.TWO, 6),
                createPit(PitId.THREE, 6),
                createPit(PitId.FOUR, 6),
                createPit(PitId.FIVE, 6),
                createPit(PitId.SIX, 6)
        ));
        Assertions.assertThat(game.getPlayerTwo().getHouse().getStones()).isZero();
        Assertions.assertThat(game.getCurrentPlayer()).isEqualTo(PlayerId.TWO);
        //SowOfSecondPitPlayerTWO -> Result [1:7, 2:0, 3:7, 4:7, 5:7, 6:7, 7:1, 8:7, 9:0, 10:7, 11:7, 12:7, 13:7, 14:1]
        game = kalahGameExecutorService.execute(game, PitId.TWO);
        playerOnePits = game.getPlayerOne().getPits();
        playerTwoPits = game.getPlayerTwo().getPits();
        Assertions.assertThat(playerOnePits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 7),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 7),
                createPit(PitId.FOUR, 7),
                createPit(PitId.FIVE, 7),
                createPit(PitId.SIX, 7)
        ));
        Assertions.assertThat(game.getPlayerOne().getHouse().getStones()).isEqualTo(1);
        Assertions.assertThat(playerTwoPits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 7),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 7),
                createPit(PitId.FOUR, 7),
                createPit(PitId.FIVE, 7),
                createPit(PitId.SIX, 7)
        ));
        Assertions.assertThat(game.getPlayerTwo().getHouse().getStones()).isEqualTo(1);
        Assertions.assertThat(game.getCurrentPlayer()).isEqualTo(PlayerId.ONE);
        //SowOfSixthPitPlayerONE -> Result [1:7, 2:0, 3:7, 4:7, 5:7, 6:0, 7:2, 8:8, 9:1, 10:8, 11:8, 12:8, 13:8, 14:1]
        game = kalahGameExecutorService.execute(game, PitId.SIX);
        playerOnePits = game.getPlayerOne().getPits();
        playerTwoPits = game.getPlayerTwo().getPits();
        Assertions.assertThat(playerOnePits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 7),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 7),
                createPit(PitId.FOUR, 7),
                createPit(PitId.FIVE, 7),
                createPit(PitId.SIX, 0)
        ));
        Assertions.assertThat(game.getPlayerOne().getHouse().getStones()).isEqualTo(2);
        Assertions.assertThat(playerTwoPits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 8),
                createPit(PitId.TWO, 1),
                createPit(PitId.THREE, 8),
                createPit(PitId.FOUR, 8),
                createPit(PitId.FIVE, 8),
                createPit(PitId.SIX, 8)
        ));
        Assertions.assertThat(game.getPlayerTwo().getHouse().getStones()).isEqualTo(1);
        Assertions.assertThat(game.getCurrentPlayer()).isEqualTo(PlayerId.TWO);

        //SowOfSixthPitPlayerTWO -- > Result [1:8, 2:1, 3:8, 4:8, 5:8, 6:1, 7:2, 8:9, 9:1, 10:8, 11:8, 12:8, 13:0,14:2]
        game = kalahGameExecutorService.execute(game, PitId.SIX);
        playerOnePits = game.getPlayerOne().getPits();
        playerTwoPits = game.getPlayerTwo().getPits();
        Assertions.assertThat(playerOnePits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 8),
                createPit(PitId.TWO, 1),
                createPit(PitId.THREE, 8),
                createPit(PitId.FOUR, 8),
                createPit(PitId.FIVE, 8),
                createPit(PitId.SIX, 1)
        ));
        Assertions.assertThat(game.getPlayerOne().getHouse().getStones()).isEqualTo(2);
        Assertions.assertThat(playerTwoPits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 9),
                createPit(PitId.TWO, 1),
                createPit(PitId.THREE, 8),
                createPit(PitId.FOUR, 8),
                createPit(PitId.FIVE, 8),
                createPit(PitId.SIX, 0)
        ));
        Assertions.assertThat(game.getPlayerTwo().getHouse().getStones()).isEqualTo(2);
        Assertions.assertThat(game.getCurrentPlayer()).isEqualTo(PlayerId.ONE);
    }

    @Test
    public void testSowOfCollectingOppositePitStoneByPlayerA() throws InvalidPitIdException {
        Game game = GameTestData.getFreshGame();
        game.getPlayerOne().setPits(Arrays.asList(
                createPit(PitId.ONE, 8),
                createPit(PitId.TWO, 1),
                createPit(PitId.THREE, 0),
                createPit(PitId.FOUR, 9),
                createPit(PitId.FIVE, 9),
                createPit(PitId.SIX, 2)
        ));
        game.getPlayerOne().getHouse().setStones(3);
        game.getPlayerTwo().setPits(Arrays.asList(
                createPit(PitId.ONE, 10),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 10),
                createPit(PitId.FOUR, 0),
                createPit(PitId.FIVE, 8),
                createPit(PitId.SIX, 0)
        ));
        game.getPlayerTwo().getHouse().setStones(2);
        game.setCurrentPlayer(PlayerId.ONE);
        game = kalahGameExecutorService.execute(game, PitId.TWO);
        List<Pit> playerOnePits = game.getPlayerOne().getPits();
        List<Pit> playerTwoPits = game.getPlayerTwo().getPits();
        Assertions.assertThat(playerOnePits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 8),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 0),
                createPit(PitId.FOUR, 9),
                createPit(PitId.FIVE, 9),
                createPit(PitId.SIX, 2)
        ));
        Assertions.assertThat(game.getPlayerOne().getHouse().getStones()).isEqualTo(4);
        Assertions.assertThat(playerTwoPits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 10),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 10),
                createPit(PitId.FOUR, 0),
                createPit(PitId.FIVE, 8),
                createPit(PitId.SIX, 0)
        ));
        Assertions.assertThat(game.getPlayerTwo().getHouse().getStones()).isEqualTo(2);
        Assertions.assertThat(game.getCurrentPlayer()).isEqualTo(PlayerId.TWO);
    }

    @Test
    public void testSowOfCollectingOppositePitStoneByPlayerB() throws InvalidPitIdException {
        Game game = GameTestData.getFreshGame();
        game.getPlayerOne().setPits(Arrays.asList(
                createPit(PitId.ONE, 0),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 3),
                createPit(PitId.FOUR, 12),
                createPit(PitId.FIVE, 10),
                createPit(PitId.SIX, 3)
        ));
        game.getPlayerOne().getHouse().setStones(15);
        game.getPlayerTwo().setPits(Arrays.asList(
                createPit(PitId.ONE, 1),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 13),
                createPit(PitId.FOUR, 2),
                createPit(PitId.FIVE, 9),
                createPit(PitId.SIX, 1)
        ));
        game.getPlayerTwo().getHouse().setStones(3);
        game.setCurrentPlayer(PlayerId.TWO);
        game = kalahGameExecutorService.execute(game, PitId.ONE);
        List<Pit> playerOnePits = game.getPlayerOne().getPits();
        List<Pit> playerTwoPits = game.getPlayerTwo().getPits();
        Assertions.assertThat(playerOnePits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 0),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 3),
                createPit(PitId.FOUR, 12),
                createPit(PitId.FIVE, 0),
                createPit(PitId.SIX, 3)
        ));
        Assertions.assertThat(game.getPlayerOne().getHouse().getStones()).isEqualTo(15);
        Assertions.assertThat(playerTwoPits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 0),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 13),
                createPit(PitId.FOUR, 2),
                createPit(PitId.FIVE, 9),
                createPit(PitId.SIX, 1)
        ));
        Assertions.assertThat(game.getPlayerTwo().getHouse().getStones()).isEqualTo(14);
        Assertions.assertThat(game.getCurrentPlayer()).isEqualTo(PlayerId.ONE);
    }

    @Test
    public void testSowOfCompletingGamePlayerOneWinner() throws InvalidPitIdException {
        Game game = GameTestData.getFreshGame();
        game.getPlayerOne().setPits(Arrays.asList(
                createPit(PitId.ONE, 0),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 1),
                createPit(PitId.FOUR, 0),
                createPit(PitId.FIVE, 0),
                createPit(PitId.SIX, 0)
        ));
        game.getPlayerOne().getHouse().setStones(40);
        game.getPlayerTwo().setPits(Arrays.asList(
                createPit(PitId.ONE, 1),
                createPit(PitId.TWO, 7),
                createPit(PitId.THREE, 0),
                createPit(PitId.FOUR, 2),
                createPit(PitId.FIVE, 0),
                createPit(PitId.SIX, 1)
        ));
        game.getPlayerTwo().getHouse().setStones(20);
        game.setCurrentPlayer(PlayerId.ONE);
        game = kalahGameExecutorService.execute(game, PitId.THREE);
        List<Pit> playerOnePits = game.getPlayerOne().getPits();
        List<Pit> playerTwoPits = game.getPlayerTwo().getPits();
        Assertions.assertThat(playerOnePits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 0),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 0),
                createPit(PitId.FOUR, 0),
                createPit(PitId.FIVE, 0),
                createPit(PitId.SIX, 0)
        ));
        Assertions.assertThat(game.getPlayerOne().getHouse().getStones()).isEqualTo(41);
        Assertions.assertThat(playerTwoPits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 1),
                createPit(PitId.TWO, 7),
                createPit(PitId.THREE, 0),
                createPit(PitId.FOUR, 2),
                createPit(PitId.FIVE, 0),
                createPit(PitId.SIX, 1)
        ));
        Assertions.assertThat(game.getPlayerTwo().getHouse().getStones()).isEqualTo(20);
        Assertions.assertThat(game.getWinner()).isEqualTo(PlayerId.ONE);
    }

    @Test
    public void testPlayerOneSowOfPitFourWith3StonesNextPlayerRemainsPlayerOne() throws InvalidPitIdException {
        Game game = GameTestData.getFreshGame();
        game.getPlayerOne().setPits(Arrays.asList(
                createPit(PitId.ONE, 0),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 1),
                createPit(PitId.FOUR, 3),
                createPit(PitId.FIVE, 0),
                createPit(PitId.SIX, 0)
        ));
        game.getPlayerOne().getHouse().setStones(40);
        game.getPlayerTwo().setPits(Arrays.asList(
                createPit(PitId.ONE, 1),
                createPit(PitId.TWO, 7),
                createPit(PitId.THREE, 0),
                createPit(PitId.FOUR, 2),
                createPit(PitId.FIVE, 0),
                createPit(PitId.SIX, 1)
        ));
        game.getPlayerTwo().getHouse().setStones(20);
        game.setCurrentPlayer(PlayerId.ONE);
        game = kalahGameExecutorService.execute(game, PitId.FOUR);
        List<Pit> playerOnePits = game.getPlayerOne().getPits();
        List<Pit> playerTwoPits = game.getPlayerTwo().getPits();
        Assertions.assertThat(playerOnePits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 0),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 1),
                createPit(PitId.FOUR, 0),
                createPit(PitId.FIVE, 1),
                createPit(PitId.SIX, 1)
        ));
        Assertions.assertThat(game.getPlayerOne().getHouse().getStones()).isEqualTo(41);
        Assertions.assertThat(playerTwoPits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 1),
                createPit(PitId.TWO, 7),
                createPit(PitId.THREE, 0),
                createPit(PitId.FOUR, 2),
                createPit(PitId.FIVE, 0),
                createPit(PitId.SIX, 1)
        ));
        Assertions.assertThat(game.getPlayerTwo().getHouse().getStones()).isEqualTo(20);
        Assertions.assertThat(game.getCurrentPlayer()).isEqualTo(PlayerId.ONE);
    }

    @Test
    public void testSowOfCompletingGamePlayerTwoWinner() throws InvalidPitIdException {
        Game game = GameTestData.getFreshGame();
        game.getPlayerOne().setPits(Arrays.asList(
                createPit(PitId.ONE, 0),
                createPit(PitId.TWO, 1),
                createPit(PitId.THREE, 1),
                createPit(PitId.FOUR, 0),
                createPit(PitId.FIVE, 0),
                createPit(PitId.SIX, 0)
        ));
        game.getPlayerOne().getHouse().setStones(25);
        game.getPlayerTwo().setPits(Arrays.asList(
                createPit(PitId.ONE, 0),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 0),
                createPit(PitId.FOUR, 0),
                createPit(PitId.FIVE, 0),
                createPit(PitId.SIX, 8)
        ));
        game.getPlayerTwo().getHouse().setStones(35);
        game.setCurrentPlayer(PlayerId.TWO);
        game = kalahGameExecutorService.execute(game, PitId.SIX);
        List<Pit> playerOnePits = game.getPlayerOne().getPits();
        List<Pit> playerTwoPits = game.getPlayerTwo().getPits();
        Assertions.assertThat(playerOnePits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 1),
                createPit(PitId.TWO, 2),
                createPit(PitId.THREE, 2),
                createPit(PitId.FOUR, 1),
                createPit(PitId.FIVE, 1),
                createPit(PitId.SIX, 0)
        ));
        Assertions.assertThat(game.getPlayerOne().getHouse().getStones()).isEqualTo(25);
        Assertions.assertThat(playerTwoPits).isEqualTo(Arrays.asList(
                createPit(PitId.ONE, 0),
                createPit(PitId.TWO, 0),
                createPit(PitId.THREE, 0),
                createPit(PitId.FOUR, 0),
                createPit(PitId.FIVE, 0),
                createPit(PitId.SIX, 0)
        ));
        Assertions.assertThat(game.getPlayerTwo().getHouse().getStones()).isEqualTo(38);
        Assertions.assertThat(game.getWinner()).isEqualTo(PlayerId.TWO);
    }


}