package step3.domain;

import step3.Utils;

public class Payment {
    private static final String INPUT_COUNT_EXCEPTION_MESSAGE = "입력값이 구입액에 비해 큽니다.";
    private static final int LOTTO_PRICE = 1000;
    private final int payment;
    private final int manualCount;

    public Payment(int payment, int manualCount) {
        Utils.isNegative(payment);
        this.payment = payment;

        validManualCount(manualCount, getLottoCount());
        this.manualCount = manualCount;
    }

    public int getPayment() {
        return this.payment;
    }

    public int getLottoCount() {
        return this.payment / LOTTO_PRICE;
    }

    public int getAutoLottoCount() {
        return getLottoCount() - this.manualCount;
    }

    public int getManualLottoCount() {
        return this.manualCount;
    }

    private void validManualCount(int manualCount, int lottoCount) {
        if (manualCount > lottoCount || Utils.isNegative(manualCount)) {
            throw new IllegalArgumentException(INPUT_COUNT_EXCEPTION_MESSAGE);
        }
    }
}
