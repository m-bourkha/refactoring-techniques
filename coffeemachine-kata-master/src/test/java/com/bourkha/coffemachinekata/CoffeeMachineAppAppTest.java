package com.bourkha.coffemachinekata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeMachineAppAppTest {

    private CoffeeMachineApp coffeeMachineApp;
    OutputStream outputStream;
    InputStream inputStream;


    @BeforeEach
    void setUp() {
        coffeeMachineApp = new CoffeeMachineApp();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest
    @MethodSource("command")
    void testQuitCommand(String command, String output) {
        byte[] bytes = command.getBytes();
        inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      //  com.bourkha.coffemachinekata.CoffeeMachine.control(new com.bourkha.coffemachinekata.Input(bufferedReader),coffeeMachine,new com.bourkha.coffemachinekata.View());
        assertThat(outputStream.toString()).isEqualToNormalizingNewlines(output);
    }

    static Stream<Arguments> command() {
        String commun = "com.bourkha.coffemachinekata.Inventory:\n" +
                "Cocoa,10\n" +
                "Coffee,10\n" +
                "Cream,10\n" +
                "Decaf Coffee,10\n" +
                "Espresso,10\n" +
                "Foamed Milk,10\n" +
                "Steamed Milk,10\n" +
                "Sugar,10\n" +
                "Whipped Cream,10\n" +
                "\n" +
                "Menu:\n" +
                "1,Caffe Americano,$3.30,true\n" +
                "2,Caffe Latte,$2.55,true\n" +
                "3,Caffe Mocha,$3.35,true\n" +
                "4,Cappuccino,$2.90,true\n" +
                "5,Coffee,$2.75,true\n" +
                "6,Decaf Coffee,$2.75,true\n" +
                "\n" +
                "Your selection: ";
        String command_1 = commun + "Dispensing: Caffe Americano\n" +
                "\n" +
                "com.bourkha.coffemachinekata.Inventory:\n" +
                "Cocoa,10\n" +
                "Coffee,10\n" +
                "Cream,10\n" +
                "Decaf Coffee,10\n" +
                "Espresso,7\n" +
                "Foamed Milk,10\n" +
                "Steamed Milk,10\n" +
                "Sugar,10\n" +
                "Whipped Cream,10\n" +
                "\n" +
                "Menu:\n" +
                "1,Caffe Americano,$3.30,true\n" +
                "2,Caffe Latte,$2.55,true\n" +
                "3,Caffe Mocha,$3.35,true\n" +
                "4,Cappuccino,$2.90,true\n" +
                "5,Coffee,$2.75,true\n" +
                "6,Decaf Coffee,$2.75,true\n" +
                "\n" +
                "Your selection: ";
        String command_2 = commun + "Dispensing: Caffe Latte\n" +
                "\n" +
                "com.bourkha.coffemachinekata.Inventory:\n" +
                "Cocoa,10\n" +
                "Coffee,10\n" +
                "Cream,10\n" +
                "Decaf Coffee,10\n" +
                "Espresso,8\n" +
                "Foamed Milk,10\n" +
                "Steamed Milk,9\n" +
                "Sugar,10\n" +
                "Whipped Cream,10\n" +
                "\n" +
                "Menu:\n" +
                "1,Caffe Americano,$3.30,true\n" +
                "2,Caffe Latte,$2.55,true\n" +
                "3,Caffe Mocha,$3.35,true\n" +
                "4,Cappuccino,$2.90,true\n" +
                "5,Coffee,$2.75,true\n" +
                "6,Decaf Coffee,$2.75,true\n" +
                "\n" +
                "Your selection: ";
        String command_3 = commun + "Dispensing: Caffe Mocha\n" +
                "\n" +
                "com.bourkha.coffemachinekata.Inventory:\n" +
                "Cocoa,9\n" +
                "Coffee,10\n" +
                "Cream,10\n" +
                "Decaf Coffee,10\n" +
                "Espresso,9\n" +
                "Foamed Milk,10\n" +
                "Steamed Milk,9\n" +
                "Sugar,10\n" +
                "Whipped Cream,9\n" +
                "\n" +
                "Menu:\n" +
                "1,Caffe Americano,$3.30,true\n" +
                "2,Caffe Latte,$2.55,true\n" +
                "3,Caffe Mocha,$3.35,true\n" +
                "4,Cappuccino,$2.90,true\n" +
                "5,Coffee,$2.75,true\n" +
                "6,Decaf Coffee,$2.75,true\n" +
                "\n" +
                "Your selection: ";
        String command_4 = commun + "Dispensing: Cappuccino\n" +
                "\n" +
                "com.bourkha.coffemachinekata.Inventory:\n" +
                "Cocoa,10\n" +
                "Coffee,10\n" +
                "Cream,10\n" +
                "Decaf Coffee,10\n" +
                "Espresso,8\n" +
                "Foamed Milk,9\n" +
                "Steamed Milk,9\n" +
                "Sugar,10\n" +
                "Whipped Cream,10\n" +
                "\n" +
                "Menu:\n" +
                "1,Caffe Americano,$3.30,true\n" +
                "2,Caffe Latte,$2.55,true\n" +
                "3,Caffe Mocha,$3.35,true\n" +
                "4,Cappuccino,$2.90,true\n" +
                "5,Coffee,$2.75,true\n" +
                "6,Decaf Coffee,$2.75,true\n" +
                "\n" +
                "Your selection: ";
        String command_5 = commun + "Dispensing: Coffee\n" +
                "\n" +
                "com.bourkha.coffemachinekata.Inventory:\n" +
                "Cocoa,10\n" +
                "Coffee,7\n" +
                "Cream,9\n" +
                "Decaf Coffee,10\n" +
                "Espresso,10\n" +
                "Foamed Milk,10\n" +
                "Steamed Milk,10\n" +
                "Sugar,9\n" +
                "Whipped Cream,10\n" +
                "\n" +
                "Menu:\n" +
                "1,Caffe Americano,$3.30,true\n" +
                "2,Caffe Latte,$2.55,true\n" +
                "3,Caffe Mocha,$3.35,true\n" +
                "4,Cappuccino,$2.90,true\n" +
                "5,Coffee,$2.75,true\n" +
                "6,Decaf Coffee,$2.75,true\n" +
                "\n" +
                "Your selection: ";
        String command_6 = commun + "Dispensing: Decaf Coffee\n" +
                "\n" +
                "com.bourkha.coffemachinekata.Inventory:\n" +
                "Cocoa,10\n" +
                "Coffee,10\n" +
                "Cream,9\n" +
                "Decaf Coffee,7\n" +
                "Espresso,10\n" +
                "Foamed Milk,10\n" +
                "Steamed Milk,10\n" +
                "Sugar,9\n" +
                "Whipped Cream,10\n" +
                "\n" +
                "Menu:\n" +
                "1,Caffe Americano,$3.30,true\n" +
                "2,Caffe Latte,$2.55,true\n" +
                "3,Caffe Mocha,$3.35,true\n" +
                "4,Cappuccino,$2.90,true\n" +
                "5,Coffee,$2.75,true\n" +
                "6,Decaf Coffee,$2.75,true\n" +
                "\n" +
                "Your selection: ";
        String command_7 = commun + "Invalid selection: 7. Try again: ";
        String command_8 = commun + "Dispensing: Caffe Americano\n" +
                "\n" +
                "com.bourkha.coffemachinekata.Inventory:\n" +
                "Cocoa,10\n" +
                "Coffee,10\n" +
                "Cream,10\n" +
                "Decaf Coffee,10\n" +
                "Espresso,7\n" +
                "Foamed Milk,10\n" +
                "Steamed Milk,10\n" +
                "Sugar,10\n" +
                "Whipped Cream,10\n" +
                "\n" +
                "Menu:\n" +
                "1,Caffe Americano,$3.30,true\n" +
                "2,Caffe Latte,$2.55,true\n" +
                "3,Caffe Mocha,$3.35,true\n" +
                "4,Cappuccino,$2.90,true\n" +
                "5,Coffee,$2.75,true\n" +
                "6,Decaf Coffee,$2.75,true\n" +
                "\n" +
                "Your selection: Dispensing: Caffe Latte\n" +
                "\n" +
                "com.bourkha.coffemachinekata.Inventory:\n" +
                "Cocoa,10\n" +
                "Coffee,10\n" +
                "Cream,10\n" +
                "Decaf Coffee,10\n" +
                "Espresso,5\n" +
                "Foamed Milk,10\n" +
                "Steamed Milk,9\n" +
                "Sugar,10\n" +
                "Whipped Cream,10\n" +
                "\n" +
                "Menu:\n" +
                "1,Caffe Americano,$3.30,true\n" +
                "2,Caffe Latte,$2.55,true\n" +
                "3,Caffe Mocha,$3.35,true\n" +
                "4,Cappuccino,$2.90,true\n" +
                "5,Coffee,$2.75,true\n" +
                "6,Decaf Coffee,$2.75,true\n" +
                "\n" +
                "Your selection: ";
        String reful = commun + commun;
        String outOfStock = commun + "Dispensing: Coffee\n" +
                "\n" +
                "com.bourkha.coffemachinekata.Inventory:\n" +
                "Cocoa,10\n" +
                "Coffee,7\n" +
                "Cream,9\n" +
                "Decaf Coffee,10\n" +
                "Espresso,10\n" +
                "Foamed Milk,10\n" +
                "Steamed Milk,10\n" +
                "Sugar,9\n" +
                "Whipped Cream,10\n" +
                "\n" +
                "Menu:\n" +
                "1,Caffe Americano,$3.30,true\n" +
                "2,Caffe Latte,$2.55,true\n" +
                "3,Caffe Mocha,$3.35,true\n" +
                "4,Cappuccino,$2.90,true\n" +
                "5,Coffee,$2.75,true\n" +
                "6,Decaf Coffee,$2.75,true\n" +
                "\n" +
                "Your selection: Dispensing: Coffee\n" +
                "\n" +
                "com.bourkha.coffemachinekata.Inventory:\n" +
                "Cocoa,10\n" +
                "Coffee,4\n" +
                "Cream,8\n" +
                "Decaf Coffee,10\n" +
                "Espresso,10\n" +
                "Foamed Milk,10\n" +
                "Steamed Milk,10\n" +
                "Sugar,8\n" +
                "Whipped Cream,10\n" +
                "\n" +
                "Menu:\n" +
                "1,Caffe Americano,$3.30,true\n" +
                "2,Caffe Latte,$2.55,true\n" +
                "3,Caffe Mocha,$3.35,true\n" +
                "4,Cappuccino,$2.90,true\n" +
                "5,Coffee,$2.75,true\n" +
                "6,Decaf Coffee,$2.75,true\n" +
                "\n" +
                "Your selection: Dispensing: Coffee\n" +
                "\n" +
                "com.bourkha.coffemachinekata.Inventory:\n" +
                "Cocoa,10\n" +
                "Coffee,1\n" +
                "Cream,7\n" +
                "Decaf Coffee,10\n" +
                "Espresso,10\n" +
                "Foamed Milk,10\n" +
                "Steamed Milk,10\n" +
                "Sugar,7\n" +
                "Whipped Cream,10\n" +
                "\n" +
                "Menu:\n" +
                "1,Caffe Americano,$3.30,true\n" +
                "2,Caffe Latte,$2.55,true\n" +
                "3,Caffe Mocha,$3.35,true\n" +
                "4,Cappuccino,$2.90,true\n" +
                "5,Coffee,$2.75,false\n" +
                "6,Decaf Coffee,$2.75,true\n" +
                "\n" +
                "Your selection: Out of stock: Coffee\n" +
                "\n" +
                "com.bourkha.coffemachinekata.Inventory:\n" +
                "Cocoa,10\n" +
                "Coffee,1\n" +
                "Cream,7\n" +
                "Decaf Coffee,10\n" +
                "Espresso,10\n" +
                "Foamed Milk,10\n" +
                "Steamed Milk,10\n" +
                "Sugar,7\n" +
                "Whipped Cream,10\n" +
                "\n" +
                "Menu:\n" +
                "1,Caffe Americano,$3.30,true\n" +
                "2,Caffe Latte,$2.55,true\n" +
                "3,Caffe Mocha,$3.35,true\n" +
                "4,Cappuccino,$2.90,true\n" +
                "5,Coffee,$2.75,false\n" +
                "6,Decaf Coffee,$2.75,true\n" +
                "\n" +
                "Your selection: ";
        return Stream.of(
                Arguments.of("q\n", commun),
                Arguments.of("1\nq", command_1),
                Arguments.of("2\nq", command_2),
                Arguments.of("3\nq", command_3),
                Arguments.of("4\nq", command_4),
                Arguments.of("5\nq", command_5),
                Arguments.of("6\nq", command_6),
                Arguments.of("6\nq", command_6),
                Arguments.of("7\nq", command_7+"\n"),
                Arguments.of("1\n2\nq", command_8),
                Arguments.of("r\nq", reful),
                Arguments.of("5\n5\n5\n5\nq", outOfStock)

        );
    }


}


