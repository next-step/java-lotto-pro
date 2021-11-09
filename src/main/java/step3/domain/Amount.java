package step3.domain;

import step3.common.exception.InvalidParamException;
import step3.domain.constance.LottoConstant;

public class Amount {
    public static final String NOT_ENOUGH_MESSAGE = String.format("최소금액은 %s%s 입니다. 로또를 구매할 수 없습니다.",
        LottoConstant.LOTTO_MINIMUM_PRICE, LottoConstant.WON);

    private final int amount;
    private int remainingAmount;

    public Amount(int amount) {
        valid(amount);

        this.amount = amount;
        this.remainingAmount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void valid(int amount) {
        if (isBelowAmount(amount)) {
            throw new InvalidParamException(NOT_ENOUGH_MESSAGE);
        }
    }

    public void minusAmount(int size) {
        int minusAmount = calculateMinusAmount(size);
        if (minusAmount > this.remainingAmount) {
            throw new InvalidParamException(LottoConstant.LACK_OF_AMOUNT);
        }
        this.remainingAmount -= minusAmount;
    }

    public int buyAvailableQuantity() {
        return this.remainingAmount / LottoConstant.LOTTO_MINIMUM_PRICE;
    }

    private int calculateMinusAmount(int size) {
        return size * LottoConstant.LOTTO_MINIMUM_PRICE;
    }

    private boolean isBelowAmount(int amount) {
        return amount < LottoConstant.LOTTO_MINIMUM_PRICE;
    }
}
