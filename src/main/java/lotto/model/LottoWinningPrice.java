package lotto.model;

import lotto.util.GameRule;

import java.util.Arrays;

public enum LottoWinningPrice {

    NONE(0, GameRule.MATCH_PRICE_NONE, false, false),
    THREE(3, GameRule.MATCH_PRICE_3, true, false),
    FOUR(4, GameRule.MATCH_PRICE_4, true, false),
    FIVE(5, GameRule.MATCH_PRICE_5, true, false),
    BONUS(5, GameRule.MATCH_PRICE_BONUS, true, true),
    SIX(6, GameRule.MATCH_PRICE_6, true, false)
    ;
    private final int winningCount;
    private final int reward;
    private final boolean view;
    private final boolean bonus;

    LottoWinningPrice(int winningCount, int reward, boolean view, boolean bonus) {
        this.winningCount = winningCount;
        this.reward = reward;
        this.view = view;
        this.bonus = bonus;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getReward() {
        return reward;
    }

    public static LottoWinningPrice getLottoWinningPrice(int winningCount,  boolean matchBonus) {

        if (winningCount == BONUS.winningCount && matchBonus) {
            return BONUS;
        }
        return Arrays.stream(LottoWinningPrice.values())
                .filter(lottoWinningPrice -> lottoWinningPrice.winningCount == winningCount)
                .findFirst()
                .orElse(LottoWinningPrice.NONE);
    }

    public boolean isView(){
        return view;
    }

}
