package step3.domain;

public class LottosGenerator {
    private static final String ZERO_OR_MINUS_PRICE_MESSAGE = "0 혹은 음수를 입력할 수 없습니다.";
    private static final String NOT_DIVISIBLE_PRICE_MESSAGE = "금액은 천단위로 나누어 떨어져야만 합니다.";

    public static Lottos generateLottos(final Price price) {
        checkPriceIsLessThanOrEqualsToZero(price);
        checkPriceIsDivisible(price);
        return new Lottos(price.calculateLottoCount());
    }

    private static void checkPriceIsLessThanOrEqualsToZero(final Price price) {
        if (price.isLessThanOrEqualsToZero()) {
            throw new IllegalArgumentException(ZERO_OR_MINUS_PRICE_MESSAGE);
        }
    }

    private static void checkPriceIsDivisible(final Price price) {
        if (price.isDivisible()) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_PRICE_MESSAGE);
        }
    }
}
