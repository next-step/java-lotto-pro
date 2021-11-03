package lotto.domain.statistics;

import static lotto.domain.purchase.PurchaseMoney.TICKET_PRICE;

public class WinningStatistics {

    private final WinningResult winningResult;

    public WinningStatistics(WinningResult winningResult) {
        this.winningResult = winningResult;
    }

    public float profitRate(int ticketAmount) {
        int totalPrize = totalPrize();
        return (float) totalPrize / (ticketAmount * TICKET_PRICE);
    }

    private int totalPrize() {
        return winningResult.totalPrize();
    }
}
