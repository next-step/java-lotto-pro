package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    WIN_WITH_FULL_MATCHES(6, 2_000_000_000),
    WIN_WITH_5_MATCHES(5, 1_500_000),
    WIN_WITH_4_MATCHES(4, 50_000),
    WIN_WITH_3_MATCHES(3, 5_000),
    NONE(0, 0);

    private final int numberOfMatch;
    private final int prize;

    LottoPrize(int numberOfMatch, int prize) {
        this.numberOfMatch = numberOfMatch;
        this.prize = prize;
    }

    public int getNumberOfMatch() {
        return this.numberOfMatch;
    }

    public int getPrize() {
        return this.prize;
    }

    public static LottoPrize valueOf(int numberOfMatch) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.getNumberOfMatch() == numberOfMatch)
                .findAny()
                .orElse(NONE);
    }
}
