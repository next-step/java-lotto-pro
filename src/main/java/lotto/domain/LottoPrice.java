package lotto.domain;

public class LottoPrice {

    private static final Money PRICE = Money.of(1000);

    public static int purchase(Money money) {
        if (money.isLessThan(PRICE)) {
            throw new IllegalArgumentException("로또 1개 가격은 1000원입니다.");
        }
        return money.divide(PRICE);
    }

    public static Money calculatePurchaseAmount(int count) {
        return PRICE.multiply(count);
    }
}
