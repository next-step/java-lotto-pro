package lotto;

import lotto.domain.*;
import lotto.domain.Number;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LotteryStatistics {
    private static final int MINIMUM_WIN_NUMBER = 3;
    private static final int MAXIMUM_WIN_NUMBER = 6;

    private static int count;
    private static Map<Integer, Integer> matches;
    private static Map<Integer, Integer> rewards;
    private static List<Result> results;

    private LotteryStatistics() {
    }

    public static void countMatches(Lottery winning, Lotteries lotteries) {
        initMatches();
        for (Lottery lottery : lotteries.list()) {
            initCount();
            compare(winning, lottery);
            count();
        }
    }

    private static void initMatches() {
        matches = new HashMap<>();
        for (int idx = MINIMUM_WIN_NUMBER; idx <= MAXIMUM_WIN_NUMBER; idx++) {
            matches.put(idx, 0);
        }
    }

    private static void initCount() {
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

    public static Summary result() {
        initRewards();
        results = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : matches.entrySet()) {
            makeRewards(entry);
        }
        return new Summary(results);
    }

    private static void initRewards() {
        rewards = new HashMap<>();
        rewards.put(3, 5000);
        rewards.put(4, 50000);
        rewards.put(5, 1500000);
        rewards.put(6, 2000000000);
    }

    private static void makeRewards(Map.Entry<Integer, Integer> entry) {
        if (entry.getKey() >= MINIMUM_WIN_NUMBER) {
            results.add(new Result(entry.getKey(), entry.getValue(), Reward.find(entry.getKey())));
        }
    }

    public static double earningsRate(Summary summary, Money money) {
        return 1.0 * summary.sum() / money.value();
    }
}
