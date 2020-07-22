package com.game.util;

import com.game.controller.KalahGameController;
import com.game.exceptions.GameIdNotFoundException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 Utility Class for creating hateoas links for game link
 */
public class Links {

    public static String getKalahGameLink(String id) {
        try {
            return linkTo(methodOn(KalahGameController.class).getGame(id)).withSelfRel().getHref();
        } catch (GameIdNotFoundException ex) {
            return "Not Available";
        }
    }
}
