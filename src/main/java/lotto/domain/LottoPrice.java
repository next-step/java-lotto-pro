package lotto.domain;

import lotto.controller.LottoCount;

public class LottoPrice {

    private static final Money PRICE = Money.of(1000);

    public static LottoCount purchase(Money money) {
        if (money.isLessThan(PRICE)) {
            throw new IllegalArgumentException("로또 1개 가격은 1000원입니다.");
        }
        return new LottoCount(money.divide(PRICE));
    }

    public static Money calculatePurchaseAmount(int count) {
        return PRICE.multiply(count);
    }
}
