package lotto.service;

import static lotto.domain.LottoCondition.TICKET_COST;
import static lotto.domain.message.ErrorMessage.INVALID_PAYMENT;

public class MoneyValidator {
    public static void validate(final int money) {
        if (money <= 0 || money % TICKET_COST.getCondition() != 0) {
            throw new IllegalArgumentException(INVALID_PAYMENT.getMessage());
        }
    }
}
