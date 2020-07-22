package com.game.service;

import com.game.entities.Game;
import com.game.entities.kalah.Pit;
import com.game.entities.kalah.PitId;
import com.game.entities.kalah.Player;
import com.game.entities.kalah.PlayerId;
import com.game.exceptions.InvalidPitIdException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 Service implementation of executing the play/move of the kalah game.
 */
@Service
@Qualifier("kalahGameExecutorServiceImpl")
public class KalahGameExecutorServiceImpl implements GameExecutorService {

    /**
     Method to execute the sow in the Kalah game

     @param game,indexPitId - the Game and sowing pit id of the move
     @return Game - Game board containing id and pits
     */
    @Override
    public Game execute(Game game, PitId indexPitId) throws InvalidPitIdException {
        Player currentPlayer = game.currentPlayer();//Current Player
        Player currentBoardSidePlayer = currentPlayer;// Player of the current board side
        Pit selectedPit = game.currentPlayer().getPit(indexPitId);
        AtomicInteger sowingStones = new AtomicInteger(selectedPit.distributeStones());
        int startPosition = indexPitId.id;
        boolean isPlayerTurnRequired = (sowingStones.intValue() > 0);
        while (sowingStones.intValue() > 0) {
            // Sow stones to pits of a specific side/player
            sowStonesAction(game, currentBoardSidePlayer, sowingStones, startPosition);
            // Apply big pit rule
            if (sowingStones.intValue() >= 1 && currentPlayer.equals(currentBoardSidePlayer)) {
                currentBoardSidePlayer.getHouse().sow();
                sowingStones.getAndDecrement();
                if (sowingStones.intValue() == 0) {
                    isPlayerTurnRequired = false;
                }
            }
            currentBoardSidePlayer = game.switchPlayerSide(currentBoardSidePlayer);
            startPosition = 0;
        }
        moveCompletionAction(game, isPlayerTurnRequired);
        return game;
    }

    private void sowStonesAction(
            Game game, Player player, AtomicInteger sowingStones, int startIndex) throws InvalidPitIdException {
        CopyOnWriteArrayList<Pit> pits = new CopyOnWriteArrayList<>(player.getPits());
        ListIterator<Pit> listIter = pits.listIterator(startIndex);
        while (listIter.hasNext() && sowingStones.intValue() > 0) {
            Pit currentPit = listIter.next();
            //Apply SnatchStone rule
            if (sowingStones.intValue() == 1 && currentPit.getStones() == 0 && player
                    .equals(game.currentPlayer())) {
                snatchStonesAction(game, currentPit, player.getPits().size());
            } else {
                currentPit.sow();
            }
            sowingStones.getAndDecrement();
        }
    }

    private void snatchStonesAction(Game game, Pit currentPit, Integer pitSize) throws InvalidPitIdException {
        // Snatch the current and opposite players Stones
        int opponentPitPosition = (pitSize - currentPit.getId().id) + 1;
        PitId pitId = PitId.fromIntValue(opponentPitPosition);
        int opponentPitStones = game.opponentPlayer().getPit(pitId).distributeStones();
        game.currentPlayer().acquireStonesToHousePit(opponentPitStones);
    }

    private void moveCompletionAction(Game game, boolean isPlayerTurnRequired) {
        if (gameCompletionRule(game)) {
            game.setWinner(determineWinnerRule(game.getPlayerOne(), game.getPlayerTwo()));
        }
        if (isPlayerTurnRequired) {
            game.changePlayer();
        }
    }

    private boolean gameCompletionRule(Game game) {
        return (checkAllPitsEmptyForPlayer(game.getPlayerTwo().getPits()) || checkAllPitsEmptyForPlayer(game
                .getPlayerOne().getPits()));
    }

    private PlayerId determineWinnerRule(Player playerOne, Player playerTwo) {
        if (playerOne.getHouse().getStones() == playerTwo.getHouse().getStones()) {
            return PlayerId.NONE;
        } else if (playerOne.getHouse().getStones() > playerTwo.getHouse().getStones()) {
            return PlayerId.ONE;
        } else {
            return PlayerId.TWO;
        }
    }

    private boolean checkAllPitsEmptyForPlayer(List<Pit> pits) {
        return pits.subList(0, pits.size() - 1).stream().mapToInt(Pit::getStones).sum() == 0;
    }
}
