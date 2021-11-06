package lotto.domain;

import lotto.common.Messages;
import lotto.exception.LottoException;

import java.util.Objects;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        if (amount < Lotto.PRICE) {
            throw new LottoException(Messages.PURCHASE_AMOUNT_LESS_THAN_LOTTO_PRICE);
        }
        this.amount = amount;
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

    public int buyLotto() {
        return amount / Lotto.PRICE;
    }
}
