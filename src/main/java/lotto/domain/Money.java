package lotto.domain;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("투입 금액은 0 이상의 숫자만 가능합니다.");
        }
        if(money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("투입 금액은 1000 단위의 숫자만 가능합니다.");
        }
        this.money = money;
    }

    public int getBuyableLottoCount() {
        return this.money / LOTTO_PRICE;
    }
}
