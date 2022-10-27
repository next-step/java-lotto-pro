package step3.domain;

public class LottoQuantity {
    private static final int LOTTO_PRICE = 1000;
    private final int quantity;

    private LottoQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static LottoQuantity of(int amount) {
        int quantity = amount / LOTTO_PRICE;
        return new LottoQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }
}
