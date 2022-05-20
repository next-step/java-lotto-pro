package lotto.service;

import lotto.model.*;
import lotto.model.Number;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LotterySummary {
    private static final int MINIMUM_WINNING_NUMBERS_MATCH = 3;
    private static final int MAXIMUM_WINNING_NUMBERS_MATCH = 6;

    private static int count;
    private static Map<Integer, Integer> matches;
    private static List<Result> results;

    private LotterySummary() {
    }

    public static Summary createWinningDetails(Lottery winning, Lotteries lotteries) {
        init();
        for (Lottery lottery : lotteries.list()) {
            clear();
            compare(winning, lottery);
            count();
        }

        for (Map.Entry<Integer, Integer> entry : matches.entrySet()) {
            summary(entry);
        }
        return new Summary(results);
    }

    private static void init() {
        matches = new HashMap<>();
        for (int idx = MINIMUM_WINNING_NUMBERS_MATCH; idx <= MAXIMUM_WINNING_NUMBERS_MATCH; idx++) {
            matches.put(idx, 0);
        }
        results = new LinkedList<>();
    }

    private static void clear() {
        count = 0;
    }

    private static void compare(Lottery winning, Lottery lottery) {
        for (Number number : lottery.list()) {
            match(winning, number);
        }
    }

    private static void match(Lottery winning, Number number) {
        if (winning.contains(number)) {
            count++;
        }
    }

    private static void count() {
        matches.put(count, matches.getOrDefault(count, 0) + 1);
    }

    private static void summary(Map.Entry<Integer, Integer> entry) {
        if (entry.getKey() >= MINIMUM_WINNING_NUMBERS_MATCH && entry.getKey() <= MAXIMUM_WINNING_NUMBERS_MATCH) {
            results.add(new Result(entry.getKey(), entry.getValue()));
        }
    }
}
