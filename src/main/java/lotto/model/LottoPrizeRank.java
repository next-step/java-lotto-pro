package lotto.model;


import java.util.stream.Stream;

public enum LottoPrizeRank {
    NONE(0, 0),
    THREE(3, 5000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

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
                .orElse(NONE);
    }
}
