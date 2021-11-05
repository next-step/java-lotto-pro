package lotto.model;

import lotto.util.GameRule;

import java.util.Arrays;

public enum LottoWinningPrice {

    NONE(0, GameRule.MATCH_PRICE_NONE),
    THREE(3, GameRule.MATCH_PRICE_3),
    FOUR(4, GameRule.MATCH_PRICE_4),
    FIVE(5, GameRule.MATCH_PRICE_5),
    SIX(6, GameRule.MATCH_PRICE_6)
    ;
    private final int winningCount;
    private final int reward;

    LottoWinningPrice(int winningCount, int reward) {
        this.winningCount = winningCount;
        this.reward = reward;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getReward() {
        return reward;
    }

    public static LottoWinningPrice getLottoWinningPrice(int winningCount) {

        return Arrays.stream(LottoWinningPrice.values())
                .filter(lottoWinningPrice -> lottoWinningPrice.winningCount == winningCount)
                .findFirst()
                .orElse(LottoWinningPrice.NONE);
    }
}
