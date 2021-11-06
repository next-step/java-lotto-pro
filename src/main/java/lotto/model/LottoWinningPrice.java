package lotto.model;

import lotto.util.GameRule;

import java.util.Arrays;

public enum LottoWinningPrice {

    NONE(0, GameRule.MATCH_PRICE_NONE, false),
    THREE(3, GameRule.MATCH_PRICE_3, true),
    FOUR(4, GameRule.MATCH_PRICE_4, true),
    FIVE(5, GameRule.MATCH_PRICE_5, true),
    SIX(6, GameRule.MATCH_PRICE_6, true)
    ;
    private final int winningCount;
    private final int reward;
    private final boolean view;

    LottoWinningPrice(int winningCount, int reward, boolean view) {
        this.winningCount = winningCount;
        this.reward = reward;
        this.view = view;
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

    public boolean isView(){
        return view;
    }
}
