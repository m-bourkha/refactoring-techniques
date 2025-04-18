package com.bourkha;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.approvaltests.Approvals.verify;

public class TheatricalPlayersTest {


    @Test
    public void exampleStatement() {
        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance(new Play("tragedy"), 55),
                new Performance(new Play("comedy"), 35),
                new Performance(new Play("tragedy"), 40)));

        TheatricalPlayers theatricalPlayers = new TheatricalPlayers();
        var result = theatricalPlayers.print(invoice);

        verify(result);
    }
}