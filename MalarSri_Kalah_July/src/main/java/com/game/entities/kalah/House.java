package com.game.entities.kalah;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Domain/Entity class to hold the Kalah Home stones of the respective player
 **/
public class House extends Pit {
    public House() {
        super(PitId.HOUSE);
    }
}
