package study.lotto.domain;

import study.util.NumberUtil;

public class Order {

    private final int quantity;
    private final int totalAmount;

    public Order(String totalAmount) {
        this.totalAmount = checkTotalAmount(totalAmount);
        this.quantity = (int) NumberUtil.divideAndCeil(this.totalAmount, Store.LOTTO_PRICE);
    }

    private int checkTotalAmount(String totalAmount) {
        int totalAmountConverted = NumberUtil.convertToPositiveIntNotContainsZero(totalAmount);

        if(totalAmountConverted >= Store.LOTTO_PRICE) {
            return totalAmountConverted;
        }

        throw new IllegalArgumentException("[ERROR] You must purchase at least one lotto.");
    }

    public int getQuantity() {
        return quantity;
    }
}
