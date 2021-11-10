package lotto;

public class Price {

    private static final int UNIT_PRICE = 1000;

    private final long price;

    public Price(final long price) {
        validateUnit(price);
        this.price = price;
    }

    private void validateUnit(final long price) {
        if (price % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("로또는 1,000원 단위로 구매할 수 있습니다.");
        }
    }

    public int calculateNumberOfUnits() {
        return (int) (price / UNIT_PRICE);
    }
}
