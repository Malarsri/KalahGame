package com.game.entities.kalah;

import com.game.exceptions.InvalidPitIdException;

import java.util.Arrays;

/**
 Enum class to hold type specification of Pit
 **/
public enum PitId {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), HOUSE(0);
    public final int id;

    PitId(int id) {
        this.id = id;
    }

    /**
     Method to extract PitId Type from the position of pit (int)

     @param value of the pit position
     @return the type PitId
     */
    public static PitId fromIntValue(int value) throws InvalidPitIdException {
        return Arrays.stream(PitId.values())
                     .filter(v -> v.id == value)
                     .findFirst()
                     .orElseThrow(() -> new InvalidPitIdException("Pit Id:" + value));
    }
}
