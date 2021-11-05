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
                    String.format("로또 구매 금액은 %d원 이상이어야 합니다.", LottoCalculator.LOTTO_PRICE));
        }
    }
}
