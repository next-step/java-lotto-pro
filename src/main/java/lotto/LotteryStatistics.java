package lotto;

import lotto.vo.*;
import lotto.vo.Number;

import java.util.*;

public class LotteryStatistics {
    private LotteryStatistics() {
    }

    private static int count;
    private static Map<Integer, Integer> matches;
    private static Map<Integer, Integer> rewards;

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
        for (int idx = 3; idx <= 6; idx++) {
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

    public static Winning result() {
        initRewards();
        List<Result> results = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : matches.entrySet()) {
            if (entry.getKey() >= 3) {
                results.add(new Result(entry.getKey(), entry.getValue(), rewards.get(entry.getKey())));
            }
        }
        return new Winning(results);
    }

    private static void initRewards() {
        rewards = new HashMap<>();
        rewards.put(3, 5000);
        rewards.put(4, 50000);
        rewards.put(5, 1500000);
        rewards.put(6, 2000000000);
    }

    public static double earningsRate(Winning winning, Money money) {
        return 1.0 * winning.sum() / money.value();
    }
}
