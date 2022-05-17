package lotto.domain;

import static lotto.domain.message.ErrorMessage.INVALID_PAYMENT;

public class LottoPaymentFactory {
    private static final int LOTTO_TICKET_COST = 1000;

    public LottoPayment create(final String moneyString) {
        final int money = validateMoneyString(moneyString);
        return new LottoPayment(money, money / LOTTO_TICKET_COST);
    }

    private int validateMoneyString(final String moneyString) {
        int money = 0;
        try {
            money = Integer.parseInt(moneyString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PAYMENT.getMessage());
        }
        checkAmount(money);
        return money;
    }

    private static void checkAmount(final int money) {
        if (money <= 0 || money % LOTTO_TICKET_COST != 0) {
            throw new IllegalArgumentException(INVALID_PAYMENT.getMessage());
        }
    }
}
