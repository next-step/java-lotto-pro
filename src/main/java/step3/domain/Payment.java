package step3.domain;

public class Payment {
    private static final int LOTTO_PRICE = 1000;
    private static final String INPUT_EXCEPTION_MESSAGE = "입력값은 0 이상이어야 합니다.";
    private final int payment;
    private final int manualCount;

    public Payment(int payment, int manualCount) {
        this.payment = checkNegative(payment);
        this.manualCount = checkNegative(manualCount);
    }

    public int getPayment() {
        return this.payment;
    }

    private int checkNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
        return value;
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
