package lotto;

import lotto.constants.LottoErrorMessage;

public class LottoPurchaseQuantity {
    private static final String MONEY_FORMAT_REGEX = "^[1-9]+[0-9]*$";

    public LottoPurchaseQuantity(String money) {
        validateFormat(money);
    }

    private void validateFormat(String money) {
        if (isNotValid(money)) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_MONEY_FORMAT);
        }
    }

    private boolean isNotValid(String money) {
        return isNull(money) || isInvalidFormat(money);
    }

    private boolean isNull(String money) {
        return money == null;
    }

    private boolean isInvalidFormat(String money) {
        return !money.matches(MONEY_FORMAT_REGEX);
    }
}
