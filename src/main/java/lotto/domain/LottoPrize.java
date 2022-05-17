package lotto.domain;

import lotto.utils.StringUtil;

import java.util.Arrays;

import static lotto.constants.LottoGameMessage.STATISTICS_PER_NUMBER_OF_MATCH_BONUS_MATCHED;

public enum LottoPrize {
    WIN_WITH_FULL_MATCHES(6, 2_000_000_000),
    WIN_WITH_5_MATCHES_AND_BONUS(5, 30_000_000),
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

    public static LottoPrize valueOf(int numberOfMatch, boolean hasBonusBall) {
        if (isSecondWinningRank(numberOfMatch, hasBonusBall)) {
            return WIN_WITH_5_MATCHES_AND_BONUS;
        }

        if (isThirdWinningRank(numberOfMatch, hasBonusBall)) {
            return WIN_WITH_5_MATCHES;
        }

        return valueOf(numberOfMatch);
    }

    private static boolean isThirdWinningRank(int matchCount, boolean hasBonusBallNumber) {
        return matchCount == WIN_WITH_5_MATCHES.getNumberOfMatch() && !hasBonusBallNumber;
    }

    private static boolean isSecondWinningRank(int matchCount, boolean hasBonusBallNumber) {
        return matchCount == WIN_WITH_5_MATCHES_AND_BONUS.getNumberOfMatch() && hasBonusBallNumber;
    }

    public String additionalWinningStatistics() {
        return this == WIN_WITH_5_MATCHES_AND_BONUS ? STATISTICS_PER_NUMBER_OF_MATCH_BONUS_MATCHED : StringUtil.EMPTY;
    }
}
