package lotto.domain;

import java.util.Arrays;

public enum LottoRankingStatus {
    MATCH3(3, false, 5_000),
    MATCH4(4, false, 50_000),
    MATCH5(5, false, 1_500_000),
    MATCH5BONUS1(5, true, 30_000_000),
    MATCH6(6, false, 2_000_000_000),
    NONE(0, false, 0);

    private final int matchAmount;
    private final boolean matchBonus;
    private final int prizeAmount;

    LottoRankingStatus(int matchAmount, boolean matchBonus, int prizeAmount) {
        this.matchAmount = matchAmount;
        this.matchBonus = matchBonus;
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

    public boolean isSameLottoRankingStatus(int matchAmount, boolean matchBonus) {
        return this.matchAmount == matchAmount && this.matchBonus == matchBonus;
    }

    public static LottoRankingStatus valueOf(int matchAmount, boolean matchBonus) {
        return Arrays.stream(LottoRankingStatus.values())
                .filter(lottoRankingStatus -> lottoRankingStatus.isSameLottoRankingStatus(matchAmount, matchBonus))
                .findFirst()
                .orElse(LottoRankingStatus.NONE);
    }
}
