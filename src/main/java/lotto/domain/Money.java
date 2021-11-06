package lotto.domain;

public class Money {
    private int money;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("0 이상의 수를 입력해야 합니다.");
        }
        this.money = money;
    }
}
