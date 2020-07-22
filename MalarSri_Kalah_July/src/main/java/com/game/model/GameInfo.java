package com.game.model;

import com.game.entities.Game;
import com.game.util.Links;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameInfo {

    String id;
    String url;
    Status status;

    public static GameInfo map(Game game) {
        String selfUrlOfGame = Links.getKalahGameLink(game.getId());
        Status currentStatus = new Status(game.getPlayerOne(), game.getPlayerTwo(), game.currentPlayer().getPlayerId());
        return new GameInfo(game.getId(), selfUrlOfGame, currentStatus);
    }
}

