package model;

import java.util.Map;

public class Revenue {

    private static final int ZERO_WIN_MONEY = 0;
    private static final int ADD_WIN_MONEY_STANDARD = 0;

    private int winMoney = 0;

    public Revenue(Map<LottoRankType, Integer> stats) {
        for (Map.Entry<LottoRankType, Integer> entry : stats.entrySet()) {
            winMoney += addWinMoneyIfValuePercent(entry.getKey(), entry.getValue());
        }
    }

    private int addWinMoneyIfValuePercent(LottoRankType rankType, Integer winCount) {
        if (winCount > ADD_WIN_MONEY_STANDARD) {
            return rankType.getWinMoney();
        }

        return ZERO_WIN_MONEY;
    }


    public double getPercent(int inputMoney) {
        return (double) winMoney / inputMoney;
    }
}
