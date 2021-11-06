package lotto.model;

public class Lotto {
    private static Money SELLING_PRICE = new Money(1000);

    public static int howManyLottosCanIBuyWith(Money money) {
        if (money.isZero()) {
            return 0;
        }
        return money.divideBy(SELLING_PRICE);
    }
}
