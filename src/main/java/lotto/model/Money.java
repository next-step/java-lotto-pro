package lotto.model;

public class Money {
    public static final int PRICE_ONE_LOTTO = 1000;
    public static final String NUMBER_PATTERN = "-?\\d+";
    public static final String NUMBER_MESSAGE = "숫자를 입력해 주세요.";
    public static final String MINIMUM_AMOUNT_MESSAGE = "최소 금액 1000원보다 작은 금액을 입력하였습니다.";
    private int amount;

    public Money(String text) {
        validateNumber(text);
        int number = Integer.parseInt(text);
        validateMinimumAmount(number);
        amount = number;
    }

    private void validateNumber(String text) {
        if (!text.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(NUMBER_MESSAGE);
        }
    }

    private void validateMinimumAmount(int amount) {
        if (amount < PRICE_ONE_LOTTO) {
            throw new IllegalArgumentException(MINIMUM_AMOUNT_MESSAGE);
        }
    }

    public int getLottoCount() {
        return this.amount / PRICE_ONE_LOTTO;
    }

    public boolean isExceed(int lottoCount) {
        return lottoCount * PRICE_ONE_LOTTO > amount;
    }
}

