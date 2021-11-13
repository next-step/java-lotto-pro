package lotto.domain;

import lotto.exception.LottoException;

import java.util.Objects;

public class PurchaseAmount {

    protected static final String PURCHASE_AMOUNT_LESS_THAN_LOTTO_PRICE = "구입 금액이 로또 가격보다 작습니다.";
    protected static final String INVALID_LOTTO_COUNT_ERROR = "구매할 로또 수는 0개 이상이어야 합니다.";
    protected static final String NOT_ENOUGH_PURCHASE_AMOUNT = "로또를 구매할 금액이 부족합니다.";

    private final int amount;

    public PurchaseAmount(int amount) {
        if (amount < Lotto.PRICE) {
            throw new LottoException(PURCHASE_AMOUNT_LESS_THAN_LOTTO_PRICE);
        }
        this.amount = amount;
    }

    public int getPurchasableLottoCount() {
        return amount / Lotto.PRICE;
    }

    public void validatePurchasableLottoCount(int count) {
        if (count < 0) {
            throw new LottoException(INVALID_LOTTO_COUNT_ERROR);
        }
        if (amount < Lotto.PRICE * count) {
            throw new LottoException(NOT_ENOUGH_PURCHASE_AMOUNT);
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
