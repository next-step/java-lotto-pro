package lotto.domain;

import java.util.Objects;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getQuantity() {
        return amount / LottoCalculator.LOTTO_PRICE;
    }

    private void validate(int amount) {
        if (amount < LottoCalculator.LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.PURCHASE_AMOUNT_MIN_ERROR.getMessage(), LottoCalculator.LOTTO_PRICE));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseAmount that = (PurchaseAmount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
