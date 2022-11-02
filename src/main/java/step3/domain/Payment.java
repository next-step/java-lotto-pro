package step3.domain;

import step3.ValidationUtils;

public class Payment {
    private static final int LOTTO_PRICE = 1000;
    private final int payment;
    private final int manualCount;

    public Payment(int payment, int manualCount) {
        ValidationUtils.isNegative(payment);
        this.payment = payment;

        ValidationUtils.validManualCount(manualCount, getLottoCount());
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
}
