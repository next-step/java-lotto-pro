package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

    NO_PRIZE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000)
    ;

    private final int matchCount;
    private final int lottoPrizeMoney;

    LottoPrize(int matchCount, int lottoPrizeMoney) {
        this.matchCount = matchCount;
        this.lottoPrizeMoney = lottoPrizeMoney;
    }

    public static LottoPrize findLottoPrize(int matchCount, boolean isMatchBonusLottoNumber) {
        if(isNoPrize(matchCount)) {
            return LottoPrize.NO_PRIZE;
        }

        if(isSecondPrize(matchCount, isMatchBonusLottoNumber)) {
            return LottoPrize.SECOND;
        }

        return Arrays.stream(LottoPrize.values()).filter(prize -> prize.getMatchCount() == matchCount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static boolean isSecondPrize(int matchCount, boolean isMatchBonusLottoNumber) {
        return LottoPrize.SECOND.matchCount == matchCount && isMatchBonusLottoNumber;
    }

    private static boolean isNoPrize(int matchCount) {
        return matchCount >= NO_PRIZE.matchCount && matchCount < FIFTH.matchCount;
    }

    public static boolean isSecondPrize(LottoPrize lottoPrize) {
        return LottoPrize.SECOND.equals(lottoPrize);
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
