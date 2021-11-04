package lotto.domain;

public class LottoCashier {
    private static final int DEFAULT_PRICE = 1000;

    public static int buy(int cash) {
        validateDefaultPrice(cash);
        return cash / DEFAULT_PRICE;
    }

    private static void validateDefaultPrice(int cash) {
        if (cash < DEFAULT_PRICE || cash % DEFAULT_PRICE != 0) {
            throw new IllegalArgumentException(String.format("%d원 단위로 구매하실 수 있습니다", DEFAULT_PRICE));
        }
    }
}
