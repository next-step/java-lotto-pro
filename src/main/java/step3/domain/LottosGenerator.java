package step3.domain;

public class LottosGenerator {
    private static final String ZERO_OR_MINUS_PRICE_MESSAGE = "0 혹은 음수를 입력할 수 없습니다.";
    private static final String NOT_DIVISIBLE_PRICE_MESSAGE = "금액은 천단위로 나누어 떨어져야만 합니다.";
    private static final int LOTTO_FIXED_PRICE = 1000;

    public static Lottos generateLottos(final int price) {
        checkPriceIsLessThanOrEqualsToZero(price);
        checkPriceIsDivisible(price);
        return new Lottos(price / LOTTO_FIXED_PRICE);
    }

    private static void checkPriceIsLessThanOrEqualsToZero(final int price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ZERO_OR_MINUS_PRICE_MESSAGE);
        }
    }

    private static void checkPriceIsDivisible(final int price) {
        if (price % LOTTO_FIXED_PRICE > 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_PRICE_MESSAGE);
        }
    }
}
