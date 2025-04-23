package com.bourkha.coffemachingkata;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoffeeMachineApp {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        View view = new View();
        view.display(coffeeMachine);
        control(coffeeMachine, view);
    }

    public static void control(CoffeeMachine coffeeMachine, View view) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = CommandFactory.EMPTY;

        while (true) {
            try {
                input = reader.readLine().toLowerCase();
                if(!CommandFactory.getCommand(input).execute(input, coffeeMachine, view)) {
                    break ;
                }
                view.display(coffeeMachine);

            } catch (Exception e) {
                view.invalidSelection(input);
            }
        }
    }

}
