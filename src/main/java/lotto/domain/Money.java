package lotto.domain;

public class Money {

    public static final int DEFAULT_LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        validMoney(money);
        this.money = money;
    }

    public int availableLottoSize() {
        return money / DEFAULT_LOTTO_PRICE;
    }

    private void validMoney(int money) {
        if (money < DEFAULT_LOTTO_PRICE) {
            throw new IllegalArgumentException(DEFAULT_LOTTO_PRICE + "원 이상의 금액을 입력하세요.");
        }
    }

}
