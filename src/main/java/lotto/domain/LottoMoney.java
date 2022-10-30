package lotto.domain;

public class LottoMoney {
    public static final int PRICE = 1000;

    private final int money;

    public LottoMoney(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int count() {
        return this.money / PRICE;
    }

    private void validateMoney(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("로또 1장 가격은 1000원입니다. 1000원 이상의 금액을 입력해주세요.");
        }
    }
}
