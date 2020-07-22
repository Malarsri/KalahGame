package com.game.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinksTest {

    @Test
    void getGameLink() {
        assertEquals("/kalah/hd29h497297", Links.getKalahGameLink("hd29h497297"));
    }
}