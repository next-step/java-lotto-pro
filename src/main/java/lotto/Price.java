package lotto;

public class Price {

    private static final int UNIT_PRICE = 1000;
    private static final int UNIT_NUMBER = 1;

    private final long price;

    public Price(final long price) {
        validateUnit(price);
        this.price = price;
    }

    public Price(final int unitNumber) {
        validateUnitNumber(unitNumber);
        this.price = (long) UNIT_PRICE * unitNumber;
    }

    private void validateUnit(final long price) {
        if (price % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("로또는 1,000원 단위로 구매할 수 있습니다.");
        }
    }

    private void validateUnitNumber(final int unitNumber) {
        if (unitNumber < UNIT_NUMBER) {
            throw new IllegalArgumentException("로또는 1장 이상 단위로 구매할 수 있습니다.");
        }
    }

    public long getValue() {
        return price;
    }

    public int calculateNumberOfUnits() {
        return (int) (price / UNIT_PRICE);
    }

    public Price multiply(final int n) {
        return new Price(this.price * n);
    }

    public Price add(final Price o) {
        return new Price(this.price + o.price);
    }
}
