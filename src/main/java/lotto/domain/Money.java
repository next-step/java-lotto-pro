package lotto.domain;

public class Money {
    public static final int PRICE = 1000;

    private final int money;

    public Money(String moneyString) {
        int money = parseInt(moneyString);
        validateMoney(money);
        this.money = money;
    }

    public int count() {
        return this.money / PRICE;
    }

    private int parseInt(String moneyString) {
        try {
            return Integer.parseInt(moneyString);
        } catch (Exception e) {
            throw new IllegalArgumentException("구매금액 입력값을 확인해주세요. 숫자만 입력 가능합니다.", e);
        }
    }

    private void validateMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("로또 1장 가격은 1000원입니다. 1000원 이상의 금액을 입력해주세요.");
        }
    }
}
