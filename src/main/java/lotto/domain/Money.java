package lotto.domain;

public class Money {
    private final int money;

    public Money(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("투입 금액은 0 이상의 숫자만 가능합니다.");
        }
        if(money % Lotto.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("투입 금액은 1000 단위의 숫자만 가능합니다.");
        }
        this.money = money;
    }

    public int getBuyableLottoCount() {
        return this.money / Lotto.LOTTO_PRICE;
    }
}
