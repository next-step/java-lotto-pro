package lotto.exception;

public class LottoPurchaseAmountException extends IllegalArgumentException {

    private static final String LOTTO_PURCHASE_MESSAGE = "구입 금액이 잘못되었습니다.";

    public LottoPurchaseAmountException() {
        super(LOTTO_PURCHASE_MESSAGE);
    }

    public LottoPurchaseAmountException(String message) {
        super(message);
    }
}
