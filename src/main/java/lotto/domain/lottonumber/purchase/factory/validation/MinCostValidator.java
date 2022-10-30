package lotto.domain.lottonumber.purchase.factory.validation;

import static lotto.domain.lottonumber.purchase.Purchase.LOTTO_COST;

public class MinCostValidator implements PurchaseValidator {

    private static final String ERROR_MIN_COST_MESSAGE = "[ERROR] 구입 가능 금액은 최소 1000원 입니다";

    @Override
    public void validate(String purchase) {
        if (Integer.parseInt(purchase) < LOTTO_COST) {
            throw new IllegalArgumentException(ERROR_MIN_COST_MESSAGE);
        }
    }
}
