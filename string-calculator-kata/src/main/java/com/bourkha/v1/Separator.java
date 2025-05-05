package com.bourkha.v1;

import lombok.Getter;

@Getter
public enum Separator {
    SEMICOLON(';'),
    ASTERIX('*'),
    HYEPHEN('-'),
    HASHTAG('#'),
    DEFAULT(','),
    MODULO('%');

    private final char name;

    Separator(char name) {
        this.name = name;
    }

    public static Separator of(char separator) {
        for (Separator sep : Separator.values()) {
            if(sep.name == separator) return sep;
        }
        return DEFAULT;
     }
}
