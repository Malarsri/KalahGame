package com.game.testdata;

import com.game.entities.Game;
import com.game.entities.kalah.House;
import com.game.entities.kalah.Pit;
import com.game.entities.kalah.PitId;
import com.game.entities.kalah.Player;
import com.game.entities.kalah.PlayerId;

import java.util.Arrays;
import java.util.List;

public class GameTestData {

    public static Game getFreshGame() {
        Game game = new Game("ug32222ueyu3r2");
        return game;
    }

    public static List<Pit> getFreshPits() {
        return Arrays.asList(
                new Pit(PitId.ONE),
                new Pit(PitId.TWO),
                new Pit(PitId.THREE),
                new Pit(PitId.FOUR),
                new Pit(PitId.FIVE),
                new Pit(PitId.SIX)
        );
    }


    public static Pit createPit(PitId pitId, int stones) {
        Pit pit = new Pit(pitId);
        pit.setStones(stones);
        return pit;
    }

    public static Game getOnGoingGame() {
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
        Player playerOne = new Player(PlayerId.ONE);
        playerOne.setPits(pitsOfPlayerOne);
        playerOne.setHouse(houseOfPlayerOne);
        List<Pit> pitsOfPlayerTwo = Arrays.asList(
                new Pit(PitId.ONE),
                new Pit(PitId.TWO),
                new Pit(PitId.THREE),
                new Pit(PitId.FOUR),
                new Pit(PitId.FIVE),
                new Pit(PitId.SIX)
        );
        House houseOfPlayerTwo = new House();
        Player playerTwo = new Player(PlayerId.TWO);
        playerTwo.setPits(pitsOfPlayerTwo);
        playerTwo.setHouse(houseOfPlayerTwo);
        Game game = new Game("w24r43rd34d4353ft53");
        game.setCurrentPlayer(PlayerId.TWO);
        game.setPlayerOne(playerOne);
        game.setPlayerTwo(playerTwo);
        return game;
    }

}
