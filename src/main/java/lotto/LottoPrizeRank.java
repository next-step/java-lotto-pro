package lotto;


import java.util.stream.Stream;

public enum LottoPrizeRank {
    NONE(0, 0),
    THREE(3, 50000),
    FOUR(4, 1500000),
    FIVE(5, 30000000),
    SIX(6, 2000000000);

    private final int numberOfMatch;
    private final int prize;

    LottoPrizeRank(int numberOfMatch, int prize) {
        this.numberOfMatch = numberOfMatch;
        this.prize = prize;
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
