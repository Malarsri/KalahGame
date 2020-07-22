package com.game.entities;

import com.game.entities.kalah.Player;
import com.game.entities.kalah.PlayerId;
import lombok.Getter;
import lombok.Setter;

/**
 Entity class for the Kalah game application
 **/
@Getter
@Setter
public class Game {
    String Id;
    Player playerOne;
    Player playerTwo;
    PlayerId currentPlayer = PlayerId.ONE;
    PlayerId winner;

    public Game(String id) {
        this.Id = id;
        this.playerOne = new Player(PlayerId.ONE);
        this.playerTwo = new Player(PlayerId.TWO);
    }

    /**
     Method to determine who is the opponent player
     **/
    public Player opponentPlayer() {
        return (currentPlayer == PlayerId.ONE) ? this.playerTwo : this.playerOne;
    }

    /**
     Method to determine who is the current player
     **/
    public Player currentPlayer() {
        return (currentPlayer == PlayerId.ONE) ? this.playerOne : this.playerTwo;
    }

    /**
     Method to swtch the board side of the player during sowing the stones
     **/
    public Player switchPlayerSide(Player player) {
        return (player.playerId == PlayerId.ONE) ? this.playerTwo : this.playerOne;
    }

    /**
     Method to swtch the player after sowing the stones
     **/
    public void changePlayer() {
        this.currentPlayer = (currentPlayer == PlayerId.ONE) ? PlayerId.TWO : PlayerId.ONE;
    }

}
