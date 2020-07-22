package com.game.entities.kalah;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 Domain/Entity class to hold the Kalah Pit stones of the respective player
 **/
@AllArgsConstructor
@Data
public class Pit {
    PitId id;
    int stones;

    /**
     Constructor for the pit.
     Assumption : Game is in default with 6 pits and 6 stones in each Pit - Configurable in future

     @param id the id of the Pit
     **/
    public Pit(PitId id) {
        this.id = id;
        this.stones = (id.equals(PitId.HOUSE)) ? 0 : 6;
    }

    /**
     Method to execute the clear logic
     **/
    public void clear() {
        this.stones = 0;
    }

    /**
     Method to execute the sow logic
     **/
    public void sow() {
        this.stones++;
    }

    /**
     Method to return the stones of the selected pit for sowing

     @return int the stones to be distributed
     **/
    public int distributeStones() {
        int stonesTobeDistributed = this.stones;
        clear();
        return stonesTobeDistributed;
    }

}
