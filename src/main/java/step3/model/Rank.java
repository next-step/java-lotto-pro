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

    public static Rank valueOf(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.TWO)
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public static Rank valueOf(int matchCount, boolean bonus) {
        Rank rank = valueOf(matchCount);
        if (rank == Rank.THIRD && bonus) {
            return Rank.TWO;
        }
        return rank;
    }

    public static Rank valueOf(BiFunction<Integer, Boolean, Boolean> operation, boolean isBonus) {
        Rank frank = Arrays.stream(values())
                .filter(rank -> operation.apply(rank.matchCount, isBonus))
                .findAny()
                .orElse(MISS);
        return frank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
