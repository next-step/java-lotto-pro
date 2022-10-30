package model;

import java.util.Map;

public class Revenue {

    private int winMoney = 0;

    public Revenue(Map<LottoRankType, Integer> stats) {
        for (Map.Entry<LottoRankType, Integer> entry : stats.entrySet()) {
            addWinMoneyIfValuePercent(entry);
        }
    }

    public int addWinMoneyIfValuePercent(Map.Entry<LottoRankType, Integer> entry) {
        if (entry.getValue() > 0) {
            winMoney += entry.getKey().getWinMoney();
        }
    }

    public double getPercent(int inputMoney) {
        return (double) winMoney / inputMoney;
    }
}
