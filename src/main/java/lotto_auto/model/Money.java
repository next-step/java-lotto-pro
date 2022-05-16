package lotto_auto.model;

public class Money {
    private final int money;
    public static final int MIN_SIZE = 1_000;
    public static final String NOT_NUMBER = "[ERROR] 구입 금액은 숫자 이외의 문자가 올 수 없습니다.";
    public static final String LESS_THAN_MIN_SIZE = "[ERROR] 구입금액은 1000원 보다 큰수이여야 합니다.";

    public Money(String value) {
        try {
            this.money = Integer.parseInt(value);
            checkMoneyMinSize();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    private void checkMoneyMinSize() {
        if (this.money < MIN_SIZE) {
            throw new IllegalArgumentException(LESS_THAN_MIN_SIZE);
        }
    }

    public int getMoney() {
        return money;
    }

    public int canBuyLottoCount() {
        return money/MIN_SIZE;
    }

}
