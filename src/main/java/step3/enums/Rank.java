package step3.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Rank {
    BASE(0, 0, 1000),
    FIFTH(5, 3, 5000),
    FOURTH(4, 4, 50000),
    THIRD(3, 5, 1500000),
    SECOND(2, 2, 30000000),
    FIRST(1, 6, 2000000000);


    private final int rank;
    private final int count;
    private final int amount;

    Rank(int rank, int count, int amount) {
        this.rank = rank;
        this.count = count;
        this.amount = amount;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

    public static Map<Integer, Integer> initRank() {
        Map<Integer, Integer> rank = new HashMap<>();

        rank.put(Rank.FIFTH.getCount(), 0);
        rank.put(Rank.FOURTH.getCount(), 0);
        rank.put(Rank.THIRD.getCount(), 0);
        rank.put(Rank.THIRD.getCount() + Rank.SECOND.getCount(), 0);
        rank.put(Rank.FIRST.getCount(), 0);

        return rank;
    }

    public static Rank rank(int matchCount, boolean isBonusMatch) {
        if (matchCount == THIRD.getCount() && isBonusMatch) {
            return SECOND;
        }
        return Arrays.stream(values()).filter(award -> award.count == matchCount)
                .findAny()
                .orElse(Rank.BASE);
    }

    public static int calculateLottoCount(int money) {
        return money / Rank.BASE.amount;
    }

    public static double statistic(Map<Integer, Integer> statistics) {

        double sum = statistics.get(Rank.FIFTH.getCount()) * Rank.FIFTH.amount;
        sum += statistics.get(Rank.FOURTH.getCount()) * Rank.FOURTH.amount;
        sum += statistics.get(Rank.THIRD.getCount()) * Rank.THIRD.amount;
        sum += statistics.get(Rank.THIRD.getCount() + Rank.SECOND.getCount()) * Rank.SECOND.amount;
        sum += statistics.get(Rank.FIRST.getCount()) * Rank.FIRST.amount;
        return Math.floor(sum / Rank.BASE.amount * 100) / 100;
    }

}
