package lotto.domain;

import lotto.domain.common.Constant;

public class Payment {

    private static final String THE_PRICE_OF_A_LOTTERY_TICKET_IS_1_000_WON = "The price of a lottery ticket is 1,000 won.";
    private static final String ONLY_NUMBERS_CAN_BE_ENTERED = "Only numbers can be entered.";
    private static final String THE_PURCHASE_AMOUNT_IS_INSUFFICIENT = "The purchase amount is insufficient.";
    private final int payment;

    public Payment(final int payment) {
        validateAmount(payment);
        this.payment = payment;
    }

    public static Payment from(final int payment) {
        return new Payment(payment);
    }

    public static Payment from(final String payment) {
        validateCharacter(payment);
        return new Payment(Integer.parseInt(payment));
    }

    private static void validateCharacter(String payment) {
        if( !payment.chars().allMatch( Character::isDigit )) {
            throw new IllegalArgumentException(ONLY_NUMBERS_CAN_BE_ENTERED);
        }
    }

    private static void validateAmount(final int payment) {
        if( payment < Constant.LOTTO_PURCHASE_PRICE) {
            throw new IllegalArgumentException(THE_PRICE_OF_A_LOTTERY_TICKET_IS_1_000_WON);
        }
    }

    public int getPurchaseCount() {
        return getAutoPurchaseCount(0);
    }

    public int getAutoPurchaseCount(final int manualPurchaseCount) {
        return this.payment / Constant.LOTTO_PURCHASE_PRICE - manualPurchaseCount;
    }
}
