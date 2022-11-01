package lotto.domain;

public class Payment {

    private static final String NUMBER_TYPE_REQUIRED_MESSAGE = "구입금액은 숫자여야 합니다.";
    private static final String POSITIVE_NUMBER_REQUIRED_MESSAGE = "구입금액은 양수여야 합니다.";
    private int payment;

    public Payment(String input) {
        this.payment = validateInputValue(input);
    }

    private int validateInputValue(String input) {
        int num = getNumberType(input);
        validateNegativeNumber(num);
        return num;
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

    private void validateNegativeNumber(int num) {
        if (num < 0) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_REQUIRED_MESSAGE);
        }
    }

    public int getPayment() {
        return this.payment;
    }
}
