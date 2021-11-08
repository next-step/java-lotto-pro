package lotto.domain;

import java.util.Arrays;

public enum LottoRankingStatus {
    MATCH3(3, 5_000),
    MATCH4(4, 50_000),
    MATCH5(5, 1_500_000),
    MATCH6(6, 2_000_000_000),
    NONE(0, 0);

    private final int matchAmount;
    private final int prizeAmount;

    LottoRankingStatus(int matchAmount, int prizeAmount) {
        this.matchAmount = matchAmount;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchAmount() {
        return matchAmount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getPrizeReward(int matchCount) {
        return prizeAmount * matchCount;
    }

    public boolean isSameMatchAmount(int matchAmount) {
        return this.matchAmount == matchAmount;
    }

    public static LottoRankingStatus getLottoRankingFromMatchAmount(int matchAmount) {
        return Arrays.stream(LottoRankingStatus.values())
                .filter(ranking -> ranking.isSameMatchAmount(matchAmount))
                .findFirst()
                .orElse(LottoRankingStatus.NONE);
    }
}
