package lotto.domain;

import lotto.util.Common;

public class Payment {

    private static final String POSITIVE_NUMBER_REQUIRED_MESSAGE = "구입금액은 양수여야 합니다.";
    private static final String MIN_PAYMENT_REQUIRED_MESSAGE = "로또 구입을 위해서는 최소 1000원 이상의 구입금액이 필요합니다.";
    private static final String ILLEGAL_MANUAL_LOTTO_CNT_MESSAGE = "수동 로또 구매 수는 %d 개 이하이어야 합니다.";
    private static final int UNIT_PRICE_PER_LOTTO = 1000;
    private int payment;

    public Payment(String input) {
        this.payment = validateInputValue(input);
    }

    private int validateInputValue(String input) {
        int payment = Common.validateNumberType(input);
        validateNegativeNumber(payment);
        validateMinPayment(payment);
        return payment;
    }

    private void validateNegativeNumber(int payment) {
        if (payment < 0) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_REQUIRED_MESSAGE);
        }
    }

    private void validateMinPayment(int payment) {
        if (payment < UNIT_PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(MIN_PAYMENT_REQUIRED_MESSAGE);
        }
    }

    private void validateMinAutoLottoCnt(int autoLottoCnt) {
        if (autoLottoCnt < 0) {
            throw new IllegalArgumentException(String.format(ILLEGAL_MANUAL_LOTTO_CNT_MESSAGE, this.payment/UNIT_PRICE_PER_LOTTO));
        }
    }

    public int getAutoLottoCnt(int manualLottoCnt) {
        int autoLottoCnt = this.payment / UNIT_PRICE_PER_LOTTO - manualLottoCnt;
        validateMinAutoLottoCnt(autoLottoCnt);
        return autoLottoCnt;
    }

    public int getPayment() {
        return this.payment;
    }
}
