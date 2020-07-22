package com.game.entities.kalah;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Getter
@Setter
public class Player {
    @JsonIgnore
    public PlayerId playerId;
    public List<Pit> pits;
    public House house;

    public Player(PlayerId playerId) {
        this.playerId = playerId;
        this.pits = loadPits();
        this.house = new House();
    }

    private List<Pit> loadPits() {
        return Arrays.asList(
                new Pit(PitId.ONE),
                new Pit(PitId.TWO),
                new Pit(PitId.THREE),
                new Pit(PitId.FOUR),
                new Pit(PitId.FIVE),
                new Pit(PitId.SIX)
        );
    }

    public Pit getPit(PitId pitId) {
        for (Pit pit : this.pits) {
            if (pit.getId().equals(pitId)) {
                return Optional.of(pit).get();
            }
        }
        return Optional.<Pit>empty().get();
    }

    public void acquireStonesToHousePit(int opponentPitStones) {
        this.house.stones = this.house.stones + opponentPitStones + 1;
    }
}
