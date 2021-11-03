package lotto.domain.exception;

public final class LeakOfPaymentException extends IllegalArgumentException {

    private static final String LEAK_OF_PAYMENT_ERROR_MESSAGE = "구입금액은 최소 1000원 이상이야 합니다.";

    public LeakOfPaymentException() {
        super(LEAK_OF_PAYMENT_ERROR_MESSAGE);
    }

}
