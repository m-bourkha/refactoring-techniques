package com.bourkha.coffemachingkata;

public class CommandFactory {
    private CommandFactory() {
    }

    public static final String EMPTY = "";
    public static final String QUIT = "q";
    public static final String RESTOCK = "r";

    static COMAND getCommand(String input) {
        return switch (input) {
            case EMPTY -> COMAND.EMPTY;
            case QUIT -> COMAND.QUIT;
            case RESTOCK -> COMAND.RESTOCK;
            default -> COMAND.DEFAULT;
        };
    }
}