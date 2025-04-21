package com.bourkha.coffemachinekata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    private BufferedReader bufferedReader;

    public Input(BufferedReader bufferedReader) {

        if (bufferedReader == null)
            this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        else this.bufferedReader = bufferedReader;
    }

    String get() {
        try {
            return bufferedReader.readLine().toLowerCase();
        } catch (IOException e) {
            return null;
        }
    }

}