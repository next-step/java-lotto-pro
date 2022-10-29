package lotto.domain.money;

import lotto.constant.LottoConstant;
import lotto.message.ErrorMessages;

public class Money {
    private final double value;

    private Money(double value) {
        this.value = value;
    }

    public static Money from(double value) {
        validate(value);
        return new Money(value);
    }

    private static void validate(double value) {
        if (value < LottoConstant.PRICE_OF_ONE_LOTTO) {
            throw new IllegalArgumentException(String.format(ErrorMessages.INVALID_PURCHASE_PRICE, (int) value));
        }
    }

    public int purchasableQuantity() {
        return (int) (this.value / LottoConstant.PRICE_OF_ONE_LOTTO);
    }
}
