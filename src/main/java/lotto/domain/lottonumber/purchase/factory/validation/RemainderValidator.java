package lotto.domain.lottonumber.purchase.factory.validation;

import static lotto.domain.lottonumber.purchase.Purchase.LOTTO_COST;

public class RemainderValidator implements PurchaseValidator {

    private static final String ERROR_REMAINDER_MESSAGE = "[ERROR] 구입 금액은 1000원 단위로만 입력 가능합니다.";
    private static final int REMAINDER_VALUE = 0;

    @Override
    public void validate(String purchase) {
        if (Integer.parseInt(purchase) % LOTTO_COST != REMAINDER_VALUE) {
            throw new IllegalArgumentException(ERROR_REMAINDER_MESSAGE);
        }
    }
}
