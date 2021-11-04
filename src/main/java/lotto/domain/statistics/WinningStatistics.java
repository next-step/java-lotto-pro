package lotto.domain.statistics;

import lotto.domain.purchase.PurchaseMoney;

public class WinningStatistics {

    private final WinningResult winningResult;

    public WinningStatistics(WinningResult winningResult) {
        this.winningResult = winningResult;
    }

    public float profitRate(PurchaseMoney purchaseMoney) {
        int totalPrize = totalPrize();
        return (float) totalPrize / purchaseMoney.getMoney();
    }

    private int totalPrize() {
        return winningResult.totalPrize();
    }
}
