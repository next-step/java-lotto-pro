package lotto.exception;

import static lotto.constant.Message.ERROR_LOTTO_TOTAL_PAYMENT_MIN;

import lotto.constant.Message;

public class LottoPaymentException extends IllegalArgumentException{
    public LottoPaymentException() {
        super(ERROR_LOTTO_TOTAL_PAYMENT_MIN);
    }
}
