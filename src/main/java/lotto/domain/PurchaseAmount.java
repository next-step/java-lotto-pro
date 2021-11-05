package lotto.domain;

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
                    String.format(Message.PURCHASE_AMOUNT_MIN_ERROR.getMessage(), LottoCalculator.LOTTO_PRICE));
        }
    }
}
