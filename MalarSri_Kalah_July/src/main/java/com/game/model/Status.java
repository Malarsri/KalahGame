package com.game.model;

import com.game.entities.kalah.Player;
import com.game.entities.kalah.PlayerId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Status {
    Player playerOne;
    Player playerTwo;
    PlayerId currentPlayer;
}
