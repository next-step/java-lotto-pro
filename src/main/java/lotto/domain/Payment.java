package lotto.domain;

public class Payment {
    private final int money;

    public Payment(final String money) {
        this.money = validateMoney(money);
    }

    private static int validateMoney(final String moneyString) throws IllegalArgumentException {
        final int money = Integer.parseInt(moneyString);
        checkAmount(money);
        return money;
    }

    private static void checkAmount(final int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
