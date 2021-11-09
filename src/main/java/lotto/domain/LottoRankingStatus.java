package lotto.domain;

import lotto.exception.WrongLottoRankingStatusException;
import lotto.ui.LottoMessage;

import java.util.Arrays;

public enum LottoRankingStatus {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
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

    public boolean isMatchBonus() {
        return matchBonus;
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

    public static boolean isNone(int matchAmount) {
        return matchAmount < LottoRankingStatus.FIFTH.getMatchAmount();
    }

    public static LottoRankingStatus valueOf(int matchAmount, boolean matchBonus) {
        if (isNone(matchAmount)) {
            return LottoRankingStatus.NONE;
        }

        return Arrays.stream(LottoRankingStatus.values())
                .filter(lottoRankingStatus -> lottoRankingStatus.isSameLottoRankingStatus(matchAmount, matchBonus))
                .findFirst()
                .orElseThrow(() -> new WrongLottoRankingStatusException(LottoMessage.WRONG_LOTTO_RANKING_STATUS_MESSAGE));
    }
}
