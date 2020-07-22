package com.game.service;

import com.game.entities.Game;
import com.game.entities.kalah.PitId;

public interface GameExecutorService {
    Game execute(Game game, PitId pitId) throws Exception;
}
