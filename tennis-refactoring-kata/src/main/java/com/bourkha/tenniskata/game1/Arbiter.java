package com.bourkha.tenniskata.game1;

import java.util.Map;

public class Arbiter {
    private  final Map<GameRule, Result> resultMap;
    public Arbiter(Player player1, Player player2) {
        resultMap = Map.ofEntries(
                Map.entry(new TieRule(), new Tie(player1, player2)),
                Map.entry(new AdvantageRule(), new Advantage(player1, player2)),
                Map.entry(new WinRule(), new Win(player1, player2))
        );
    }

    public  Result result(Player player1, Player player2) {

        return resultMap.entrySet().stream()
                .filter(entry -> entry.getKey().test(player1.getScore(), player2.getScore()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(new Ongoing(player1, player2));

    }
}