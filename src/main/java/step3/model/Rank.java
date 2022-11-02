package step3.model;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Rank {

    FIRST((matchCount, isBonus) -> matchCount == 6, 6, 2_000_000_000),
    SECOND((matchCount, isBonus) -> matchCount == 5 && isBonus, 5, 30_000_000),
    THIRD((matchCount, isBonus) -> matchCount == 5 && !isBonus, 5, 1_500_000),
    FOURTH((matchCount, isBonus) -> matchCount == 4, 4, 50_000),
    FIFTH((matchCount, isBonus) -> matchCount == 3, 3, 5_000),
    MISS((matchCount, isBonus) -> matchCount < 3, 0, 0);

    private final int winningPrice;
    private final BiFunction<Integer, Boolean, Boolean> matchFunction;
    private final int matchCount;

    Rank(BiFunction<Integer, Boolean, Boolean> matchFunction, int matchCount, int winningPrice) {
        this.matchCount = matchCount;
        this.matchFunction = matchFunction;
        this.winningPrice = winningPrice;
    }

    public static Rank valueOf(int matchCount, boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchFunction.apply(matchCount, hasBonus))
                .findFirst()
                .orElse(MISS);
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public int getMatchCount() {
        return matchCount;
    }

}
