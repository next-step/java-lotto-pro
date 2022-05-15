package lotto_auto.model;

public class Money {
    int money;
    public static final int LOTTO_PRICE = 1_000;
    public static final int MIN_SIZE = 0;
    public static final String NOT_NUMBER = "[ERROR] 구입 금액은 숫자 이외의 문자가 올 수 없습니다.";
    public static final String LESS_THAN_MIN_SIZE = "[ERROR] 구입금액은 0보다 큰수이여야 합니다.";

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
        if (money < LOTTO_PRICE) {
            return 0;
        }
        return money/LOTTO_PRICE;
    }

}
