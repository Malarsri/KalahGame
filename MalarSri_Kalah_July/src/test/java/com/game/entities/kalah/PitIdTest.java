package com.game.entities.kalah;

import com.game.exceptions.InvalidPitIdException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PitIdTest {

    @Test
    void fromValidIntValueThenSuccess() throws InvalidPitIdException {
        assertEquals(PitId.ONE, PitId.fromIntValue(1));
        assertEquals(PitId.TWO, PitId.fromIntValue(2));
        assertEquals(PitId.THREE, PitId.fromIntValue(3));
        assertEquals(PitId.FOUR, PitId.fromIntValue(4));
        assertEquals(PitId.FIVE, PitId.fromIntValue(5));
        assertEquals(PitId.SIX, PitId.fromIntValue(6));
    }

    @Test
    void fromInvalidIntValueThenInvalidPitIdException() throws InvalidPitIdException {
        assertThrows(InvalidPitIdException.class, () -> PitId.fromIntValue(9));
    }
}