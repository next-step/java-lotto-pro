package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

    NO_PRIZE(0, 0, "0~2개 일치 (0원)"),
    FOURTH(3, 5000, "3개 일치 (5000원)"),
    THIRD(4, 50000, "4개 일치 (50000원)"),
    SECOND(5, 1500000, "5개 일치 (1500000원)"),
    FIRST(6, 2000000000, "6개 일치 (2000000000원)")
    ;

    private final int matchCount;
    private final int lottoPrizeMoney;
    private final String lottoPrizeMessage;

    LottoPrize(int matchCount, int lottoPrizeMoney, String lottoPrizeMessage) {
        this.matchCount = matchCount;
        this.lottoPrizeMoney = lottoPrizeMoney;
        this.lottoPrizeMessage = lottoPrizeMessage;
    }

    public static LottoPrize findLottoPrize(int matchCount) {
        return Arrays.stream(LottoPrize.values()).filter(prize -> prize.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NO_PRIZE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getLottoPrizeMoney() {
        return lottoPrizeMoney;
    }
}
