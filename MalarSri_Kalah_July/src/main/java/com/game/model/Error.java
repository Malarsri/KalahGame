package com.game.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Error {
    String code;
    String message;

    public static Error from(Exception exception) {
        return Error.builder().code("Error").message(exception.getMessage()).build();
    }
}
