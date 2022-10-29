package step3.domain;

public class LottoQuantity {
    private static final int LOTTO_PRICE = 1000;
    private final int quantity;

    private LottoQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static LottoQuantity of(int amount) {
        validateAmount(amount);
        int quantity = amount / LOTTO_PRICE;
        return new LottoQuantity(quantity);
    }

    private static void validateAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 금액은 " + LOTTO_PRICE + " 이상이어야 합니다.");
        }
    }

    public int getQuantity() {
        return quantity;
    }
}
