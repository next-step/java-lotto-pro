package lotto.enums;

import java.util.Arrays;

public enum Rank {
     FIRST(6, 2_000_000_000)
    , SECOND(5, 1_500_000)
    , THIRD(4, 50_000)
    , FOUR(3, 5_000)
    , NO_RANK(0, 0)
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

    public int prizeMoney(int count) {
        return this.prize * count;
    }

    public boolean win() {
        return this != Rank.NO_RANK;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int prize() {
        return prize;
    }
}
