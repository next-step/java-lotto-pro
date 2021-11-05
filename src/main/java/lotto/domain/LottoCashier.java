package lotto.domain;

public class LottoCashier {
    private static final Money DEFAULT_PRICE = Money.of(1000);

    public static int buy(Money cash) {
        validateDefaultPrice(cash);
        return cash.divide(DEFAULT_PRICE).intValue();
    }

    private static void validateDefaultPrice(Money cash) {
        if (cash.isLessThan(DEFAULT_PRICE) || cash.isModResultZero(DEFAULT_PRICE)) {
            throw new IllegalArgumentException(String.format("%d원 단위로 구매하실 수 있습니다", DEFAULT_PRICE.intValue()));
        }
    }
}
