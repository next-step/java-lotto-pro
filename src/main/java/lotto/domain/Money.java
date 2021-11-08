package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.Objects;

public class Money {

    private int purchaseAmount;

    public Money(int purchaseAmount) {
        purchaseAmountOneThousandWonUnitValid(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void purchaseAmountOneThousandWonUnitValid(int purchaseAmount) {
        if (purchaseAmount < LottoIssuanceCount.LOTTO_PRICE || purchaseAmount % LottoIssuanceCount.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_ONE_THOUSAND_WON.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return purchaseAmount == money.purchaseAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseAmount);
    }
}
