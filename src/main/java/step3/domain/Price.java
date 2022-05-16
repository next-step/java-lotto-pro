package step3.domain;

public class Price {
    private static final String ZERO_OR_MINUS_PRICE_MESSAGE = "0 혹은 음수를 입력할 수 없습니다.";
    private static final String NOT_DIVISIBLE_PRICE_MESSAGE = "금액은 천단위로 나누어 떨어져야만 합니다.";

    private final int price;

    public Price(int price) {
        checkPriceIsLessThanOrEqualsToZero(price);
        checkPriceIsDivisible(price);
        this.price = price;
    }

    public int calculateLottoCount() {
        return price / Lotto.LOTTO_FIXED_PRICE;
    }

    public double calculateYield(final int totalReward) {
        return totalReward / (double) price;
    }

    private void checkPriceIsLessThanOrEqualsToZero(final int price) {
        if (isLessThanOrEqualsToZero(price)) {
            throw new IllegalArgumentException(ZERO_OR_MINUS_PRICE_MESSAGE);
        }
    }

    private boolean isLessThanOrEqualsToZero(final int price) {
        return price <= 0;
    }

    private void checkPriceIsDivisible(final int price) {
        if (isDivisible(price)) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_PRICE_MESSAGE);
        }
    }

    public boolean isDivisible(final int price) {
        return price % Lotto.LOTTO_FIXED_PRICE > 0;
    }
}
