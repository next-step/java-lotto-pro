package lotto.service;

import static lotto.domain.LottoCondition.TICKET_COST;
import static lotto.domain.message.ErrorMessage.INVALID_PAYMENT;

public class StringToPaymentConverter {
    public static int convert(final String moneyString) {
        final int money = parseInt(moneyString);
        validate(money);
        return money;
    }

    private static int parseInt(final String moneyString) {
        try {
            return Integer.parseInt(moneyString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PAYMENT.getMessage());
        }
    }

    private static void validate(final int money) {
        if (money <= 0 || money % TICKET_COST.getCondition() != 0) {
            throw new IllegalArgumentException(INVALID_PAYMENT.getMessage());
        }
    }
}
