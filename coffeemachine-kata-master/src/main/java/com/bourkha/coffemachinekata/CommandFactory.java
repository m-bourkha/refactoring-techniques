package com.bourkha.coffemachinekata;

public class CommandFactory {
    private CommandFactory() {
    }
    public static COMMAND from(String command) {
        return switch (command) {
            case "" -> COMMAND.EMPTY;
            case "q" -> COMMAND.QUIT;
            case "r" -> COMMAND.RESTOCK;
            default -> COMMAND.DEFAULT;
        };
    }
}
