package lotto.domain;

public class LottoPrice {

    private static final int PRICE = 1_000;

    public static int purchase(int money) {
        if (money < PRICE) {
            throw new IllegalArgumentException("로또 1개 가격은 1000원입니다.");
        }
        return money / PRICE;
    }

    public static int calculatePurchaseAmount(int count) {
        return count * PRICE;
    }
}
