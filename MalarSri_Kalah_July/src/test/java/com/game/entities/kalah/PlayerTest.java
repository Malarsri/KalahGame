package com.game.entities.kalah;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
class PlayerTest {

    @Test
    void getPit() {
        Player player = new Player(PlayerId.ONE);
        Assertions.assertThat(new Pit(PitId.SIX, 6).equals(player.getPit(PitId.SIX)));
    }

    @Test
    void acquireStonesToHousePit() {
        Player player = new Player(PlayerId.ONE);
        player.acquireStonesToHousePit(6);
        Assertions.assertThat(player.getHouse().getStones() == 2);

    }
}