package lotto.domain;

public class Payment {

    private static final String NUMBER_TYPE_REQUIRED_MESSAGE = "구입금액은 숫자여야 합니다.";
    private static final String POSITIVE_NUMBER_REQUIRED_MESSAGE = "구입금액은 양수여야 합니다.";
    private static final String MIN_PAYMENT_REQUIRED_MESSAGE = "로또 구입을 위해서는 최소 1000원 이상의 구입금액이 필요합니다.";
    private static final int UNIT_PRICE_PER_LOTTO = 1000;
    private int payment;

    public Payment(String input) {
        this.payment = validateInputValue(input);
    }

    private int validateInputValue(String input) {
        int payment = getNumberType(input);
        validateNegativeNumber(payment);
        validateMinPayment(payment);
        return payment;
    }

    private int getNumberType(String input) {
        int num = 0;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_TYPE_REQUIRED_MESSAGE);
        }
        return num;
    }

    private void validateNegativeNumber(int payment) {
        if (payment < 0) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_REQUIRED_MESSAGE);
        }
    }

    private void validateMinPayment(int payment) {
        if (payment < UNIT_PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(MIN_PAYMENT_REQUIRED_MESSAGE);
        }
    }

    public int getPurchasedLottoCnt() {
        return this.payment / UNIT_PRICE_PER_LOTTO;
    }

    public int getPayment() {
        return this.payment;
    }
}
