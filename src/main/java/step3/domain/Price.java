package step3.domain;

public class Price {
    private final int price;

    public Price(int price) {
        this.price = price;
    }

    public boolean isLessThanOrEqualsToZero() {
        return this.price <= 0;
    }

    public boolean isDivisible() {
        return this.price % Lotto.LOTTO_FIXED_PRICE > 0;
    }

    public int calculateLottoCount() {
        return price / Lotto.LOTTO_FIXED_PRICE;
    }
}
