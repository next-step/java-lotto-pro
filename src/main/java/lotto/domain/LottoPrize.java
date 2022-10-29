package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

    NO_PRIZE(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000)
    ;

    private final int matchCount;
    private final int lottoPrizeMoney;

    LottoPrize(int matchCount, int lottoPrizeMoney) {
        this.matchCount = matchCount;
        this.lottoPrizeMoney = lottoPrizeMoney;
    }

    public static LottoPrize findLottoPrize(int matchCount) {
        return Arrays.stream(LottoPrize.values()).filter(prize -> prize.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NO_PRIZE);
    }

    public static boolean isNoPrize(LottoPrize lottoPrize) {
        return LottoPrize.NO_PRIZE.equals(lottoPrize);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getLottoPrizeMoney() {
        return lottoPrizeMoney;
    }
}
