package lotto.enums;

import lotto.domain.Money;

import java.util.Arrays;

public enum Rank {
     NO_RANK(0, 0)
    , FIFTH(3, 5_000)
    , FOURTH(4, 50_000)
    , THIRD(5, 1_500_000)
    , SECOND(5, 30_000_000)
    , FIRST(6, 2_000_000_000)
    ;

    private final int matchingCount;
    private final int prize;

    Rank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Rank of(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == matchCount)
                .findFirst()
                .orElse(NO_RANK);
    }

    public Money prizeMoney(int count) {
        return Money.of(this.prize * count);
    }

    public boolean win() {
        return this != Rank.NO_RANK;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public Money prize() {
        return Money.of(prize);
    }

    public Rank convertSecondPrize(boolean bonusBall) {
        if (isSecondPrize(bonusBall)) {
            return SECOND;
        }
        return this;
    }

    private boolean isSecondPrize(boolean bonusBall) {
        return this == THIRD && bonusBall;
    }
}
