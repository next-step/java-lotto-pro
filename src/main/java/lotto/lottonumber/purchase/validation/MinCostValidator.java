package lotto.lottonumber.purchase.validation;

import static lotto.lottonumber.purchase.Purchase.LOTTO_COST;

public class MinCostValidator implements PurchaseValidator {

    @Override
    public void validate(String purchase) {
        if (Integer.parseInt(purchase) < LOTTO_COST) {
            throw new IllegalArgumentException(ERROR_MIN_COST_MESSAGE);
        }
    }
}
