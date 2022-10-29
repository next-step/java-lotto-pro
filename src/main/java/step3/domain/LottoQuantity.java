package step3.domain;

public class LottoQuantity {
    private final int quantity;

    public LottoQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoQuantity) {
            LottoQuantity lottoquantity = (LottoQuantity) obj;
            return quantity == lottoquantity.getQuantity();
        }
        return false;
    }
}
