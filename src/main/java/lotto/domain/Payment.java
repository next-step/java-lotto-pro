package lotto.domain;

public class Payment {
    private final int money;

    public Payment(final String money) {
        this.money = Integer.parseInt(money);
    }
}
