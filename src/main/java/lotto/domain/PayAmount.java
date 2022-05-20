package lotto.domain;

import lotto.domain.error.PayAmountErrorCode;
import lotto.infrastructure.util.StringUtils;

import java.util.Objects;

public class PayAmount {

    private final static int MIN_PAY_AMOUNT = 1_000;
    private final int payAmount;

    public static int calculate(LottoCount lottoCount) {
        return lottoCount.getLottoCount() * MIN_PAY_AMOUNT;
    }

    public PayAmount(String payAmount) {
        validateNullOrEmpty(payAmount);
        validatePositiveNumber(payAmount);

        this.payAmount = Integer.parseInt(payAmount);

        validateMinimumPayAmount(this.payAmount);
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

    private void validateMinimumPayAmount(final Integer payAmount) {
        if (payAmount < MIN_PAY_AMOUNT) {
            throw new IllegalArgumentException(
                    String.format(PayAmountErrorCode.ALLOW_MIN_PAY_AMOUNT.getMessage(), MIN_PAY_AMOUNT));
        }
    }

    public LottoCount calculateLottoCount() {
        int lottoCount = payAmount / MIN_PAY_AMOUNT;
        return new LottoCount(lottoCount);
    }
}
