package lotto.domain;

import lotto.view.OutputView;

public class PayAmount {

    private static final String ERROR_MESSAGE_INVALID_PAY_AMOUNT = "[ERROR] 로또 구매 불가 금액";
    public static final int LOTTO_PRICE = 1000;
    private final int payAmount;

    public PayAmount(int payAmount) {
        validatePayAmount(payAmount);
        this.payAmount = payAmount;
    }

    private void validatePayAmount(int payAmount) {
        if (payAmount < LOTTO_PRICE) {
            try {
                throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_PAY_AMOUNT);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw e;
            }
        }
    }

    public int totalLottoAmount() {
        return payAmount / LOTTO_PRICE;
    }
}
