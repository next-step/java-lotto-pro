package lotto.domain;

public class PurchaseAmount extends Amount {

    private final static int MIN_PRICE = 1_000;
    private final static String ILLEGAL_AMOUNT_ERROR_MESSAGE = "적절하지 않은 금액입니다.";

    public PurchaseAmount(final long amount) {
        super(amount);
        validatePurchaseAmount(amount);
    }

    private void validatePurchaseAmount(long amount) {
        if(amount < MIN_PRICE) {
            throw new IllegalArgumentException(ILLEGAL_AMOUNT_ERROR_MESSAGE);
        }
    }

    public long divide(Amount otherAmount) {
        return super.amount / otherAmount.amount;
    }

}
