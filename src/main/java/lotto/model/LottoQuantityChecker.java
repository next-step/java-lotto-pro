package lotto.model;

public class LottoQuantityChecker {
    private static final int LOTTO_PRICE = 1000;

    public static int calculate(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }
}
