package lotto.model;

public class Money {
    private static final String REGEX = "[0-9]+";
    private static final String INVALID_PRICE = "1000원 단위의 금액을 입력하세요";
    private static final String NUMBER_ERROR_MESSAGE = "숫자만 입력해주세요.";
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(String price) {
        validateNumber(price);
        validateStandard(price);
        this.money = Integer.parseInt(price);
    }

    private static void validateNumber(String price) {
        if (!price.matches(REGEX)) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateStandard(String price) {
        if (Integer.parseInt(price) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
    }

    public int getMoney() {
        return money;
    }
}
