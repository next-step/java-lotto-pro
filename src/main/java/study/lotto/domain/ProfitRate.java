package study.lotto.domain;

import study.util.NumberUtil;

public class ProfitRate {

    private final int purchaseAmount;
    private double profitRate = NumberUtil.INIT_ZERO;

    public ProfitRate(int quantity) {
        this.purchaseAmount = quantity * Store.LOTTO_PRICE;
    }

    public void calculate(long totalAmount) {
        profitRate = ((double) totalAmount)/purchaseAmount;
    }

    @Override
    public String toString() {
        return String.format("%.2f", profitRate);
    }
}
