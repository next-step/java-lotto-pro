package step3.domain;

public class LottoQuantity {
    private final int quantity;

    private LottoQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static LottoQuantity of(int amount) {
        int quantity = amount / 1000;
        return new LottoQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }
}
