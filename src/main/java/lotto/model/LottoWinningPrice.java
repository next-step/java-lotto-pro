package lotto.model;

import lotto.util.GameRule;

public enum LottoWinningPrice {

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
}
