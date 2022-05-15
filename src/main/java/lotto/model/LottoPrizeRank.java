package lotto.model;


import java.util.stream.Stream;

public enum LottoPrizeRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int numberOfMatch;
    private final int prize;

    LottoPrizeRank(int numberOfMatch, int prize) {
        this.numberOfMatch = numberOfMatch;
        this.prize = prize;
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoPrizeRank find(int numberOfMatch) {
        return Stream.of(values())
                .filter(rank -> rank.numberOfMatch == numberOfMatch)
                .findAny()
                .orElse(MISS);
    }
}
