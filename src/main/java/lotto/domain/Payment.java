package lotto.domain;

import lotto.domain.common.Constant;

public class Payment {

    private static final String THE_PRICE_OF_A_LOTTERY_TICKET_IS_1_000_WON = "The price of a lottery ticket is 1,000 won.";
    private final int payment;

    public Payment(final int payment) {
        validate(payment);
        this.payment = payment;
    }

    public static Payment from(final int payment) {
        validate(payment);
        return new Payment(payment);
    }

    private static void validate(final int payment) {
        if( payment < Constant.LOTTO_PURCHASE_PRICE) {
            throw new IllegalArgumentException(THE_PRICE_OF_A_LOTTERY_TICKET_IS_1_000_WON);
        }
    }

    public int getPurchaseCount() {
        return this.payment / Constant.LOTTO_PURCHASE_PRICE;
    }
}
