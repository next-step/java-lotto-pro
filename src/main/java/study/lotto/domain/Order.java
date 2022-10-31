package study.lotto.domain;

import study.message.LottoExceptionCode;
import study.util.NumberUtil;

public class Order {

    private final int quantity;
    private final int totalAmount;

    public Order(String totalAmount) {
        this.totalAmount = checkTotalAmount(totalAmount);
        this.quantity = (int) NumberUtil.divideAndCeil(this.totalAmount, Store.LOTTO_PRICE);
    }

    private int checkTotalAmount(String totalAmount) {
        try {
            int totalAmountConverted = NumberUtil.convertToPositiveIntNotContainsZero(totalAmount);
            checkLottoSize(totalAmountConverted);

            return totalAmountConverted;
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(LottoExceptionCode.INSUFFICIENT_FUNDS.getMessage());
        }
    }

    private void checkLottoSize(int totalAmountCoverted) {
        if (totalAmountCoverted < Store.LOTTO_PRICE) {
            throw new IllegalArgumentException(LottoExceptionCode.INSUFFICIENT_FUNDS.getMessage());
        }
    }

    public int getQuantity() {
        return quantity;
    }
}
