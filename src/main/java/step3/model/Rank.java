package step3.model;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Rank {
    FIRST(6, 2_000_000_000),
    TWO(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int winningPrice;

    Rank(int matchCount, int winningPrice) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public static Rank valueOf(BiFunction<Integer,Boolean,Boolean> op) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.TWO)
                .filter(rank -> op.apply(rank.matchCount,true))
                .findFirst()
                .orElse(MISS);
    }


    public static Rank valueOf(BiFunction<Integer,Boolean,Boolean> op,boolean isBonus) {
        Rank rank = valueOf(op);
        if (rank == Rank.THIRD && isBonus) {
            return Rank.TWO;
        }
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
