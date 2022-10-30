package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

    NO_PRIZE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
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

    public static LottoPrize findLottoPrize(int matchCount, boolean isMatchBonusLottoNumber) {
        LottoPrize lottoPrize = Arrays.stream(LottoPrize.values()).filter(prize -> prize.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NO_PRIZE);

        if(isSecondPrize(matchCount, isMatchBonusLottoNumber)) {
            return LottoPrize.SECOND;
        }
        return lottoPrize;
    }

    private static boolean isSecondPrize(int matchCount, boolean isMatchBonusLottoNumber) {
        return LottoPrize.SECOND.matchCount == matchCount && isMatchBonusLottoNumber;
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
