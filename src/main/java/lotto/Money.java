package lotto;

public class Money implements Comparable<Money> {

    public static final Money ONE_THOUSAND = of("1000");

    private int value;

    protected Money(String value) {
        this.value = validate(value);
    }

    public static Money of(String value) {
        return new Money(value);
    }

    public boolean canPurchase(Purchasable purchasable) {
        if (purchasable == null) {
            return false;
        }
        final Money money = purchasable.price();
        int i = compareTo(money);
        return i >= 0;
    }

    public void purchase(Purchasable purchasable) {
        if (!canPurchase(purchasable)) {
            throw new CanNotPurchaseException(this, purchasable);
        }
        final Money money = purchasable.price();
        value -= money.value;
    }

    private static int validate(String value) {
        if (value == null || value.isEmpty()) {
            throw new MoneyFormatException(value);
        }
        int number = Integer.parseInt(value);
        if (number <= 0) {
            throw new MoneyFormatException(value);
        }
        return number;
    }

    @Override
    public int compareTo(Money other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
