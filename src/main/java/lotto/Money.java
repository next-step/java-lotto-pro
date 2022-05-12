package lotto;

public class Money {

    public static final Money ONE_THOUSAND = of("1000");

    private final int value;

    protected Money(String value) {
        throw new RuntimeException("create");
    }

    public static Money of(String value) {
        return new Money(value);
    }

    public boolean canPurchase(Purchasable purchasable) {
        throw new RuntimeException("canPurchase");
    }

    public void purchase(Purchasable purchasable) {
        throw new RuntimeException("purchase");
    }
}
