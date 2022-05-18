package lotto.domain;

import lotto.infrastructure.error.PayAmountErrorCode;
import lotto.infrastructure.util.StringUtils;

import java.util.Objects;

public class PayAmount {

    private final static int MIN_PAY_AMOUNT = 1_000;
    private final int payAmount;

    public static int calculate(int lottoCount) {
        return lottoCount * MIN_PAY_AMOUNT;
    }

    public PayAmount(String payAmount) {
        validateNullOrEmpty(payAmount);
        validatePositiveNumber(payAmount);
        validateMinimumPayAmount(payAmount);

        this.payAmount = Integer.parseInt(payAmount);
    }

    public int calculateLottoCount() {
        return payAmount / MIN_PAY_AMOUNT;
    }

    private void validateNullOrEmpty(final String payAmount) {
        if (Objects.isNull(payAmount) || StringUtils.isBlank(payAmount)) {
            throw new IllegalArgumentException(PayAmountErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
        }
    }

    private void validatePositiveNumber(final String payAmount) {
        if (!StringUtils.isPositiveNumber(payAmount)) {
            throw new IllegalArgumentException(
                    String.format(PayAmountErrorCode.ONLY_ALLOW_POSITIVE_NUMBER.getMessage(), payAmount));
        }
    }

    private void validateMinimumPayAmount(final String payAmount) {
        if (Integer.parseInt(payAmount) < MIN_PAY_AMOUNT) {
            throw new IllegalArgumentException(
                    String.format(PayAmountErrorCode.ALLOW_MIN_PAY_AMOUNT.getMessage(), MIN_PAY_AMOUNT));
        }
    }
}
