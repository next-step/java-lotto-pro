package lotto.domain.lottonumber.purchase.validation;

import static lotto.domain.lottonumber.purchase.Purchase.LOTTO_COST;

public class RemainderValidator implements PurchaseValidator {

    private static final int REMAINDER_VALUE = 0;

    @Override
    public void validate(String purchase) {
        if (Integer.parseInt(purchase) % LOTTO_COST != REMAINDER_VALUE) {
            throw new IllegalArgumentException(ERROR_REMAINDER_MESSAGE);
        }
    }
}
