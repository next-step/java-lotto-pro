package lotto.domain;

import lotto.domain.error.PayAmountErrorCode;

public class PayAmount {

    private static final int MIN_PAY_AMOUNT = 1_000;
    private final int payAmount;

    public static int calculate(LottoCount lottoCount) {
        return lottoCount.getLottoCount() * MIN_PAY_AMOUNT;
    }

    public PayAmount(int payAmount) {
        validateMinimumPayAmount(payAmount);
        this.payAmount = payAmount;
    }
    
    private void validateMinimumPayAmount(final Integer payAmount) {
        if (payAmount < MIN_PAY_AMOUNT) {
            throw new IllegalArgumentException(
                    String.format(PayAmountErrorCode.ALLOW_MIN_PAY_AMOUNT.getMessage(), MIN_PAY_AMOUNT));
        }
    }

    public LottoCount calculateAutoLottoCount(final LottoCount manualLottoCount) {
        int lottoCount = (payAmount / MIN_PAY_AMOUNT) - manualLottoCount.getLottoCount();
        return new LottoCount(lottoCount);
    }
}
