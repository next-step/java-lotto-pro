package study.lotto.domain;

import study.util.NumberUtil;

public class Order {

    private final int quantity;
    private final int totalAmount;

    public Order(String totalAmount) {
        this.totalAmount = NumberUtil.convertToPositiveIntNotContainsZero(totalAmount);
        this.quantity = (int) NumberUtil.divideAndCeil(this.totalAmount, Store.LOTTO_PRICE);
    }

    public int getQuantity() {
        return quantity;
    }
}
