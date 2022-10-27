package lotto.purchase.validation;

public class RemainderValidator implements PurchaseValidator {

    private static final int BASE_VALUE = 1000;
    private static final int REMAINDER_VALUE = 0;

    @Override
    public void validate(String purchase) {
        if (Integer.parseInt(purchase) % BASE_VALUE != REMAINDER_VALUE) {
            throw new IllegalArgumentException(ERROR_REMAINDER_MESSAGE);
        }
    }
}
