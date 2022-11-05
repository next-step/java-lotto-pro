package lotto.ui.dto;

import lotto.domain.lotto.Money;

public class BuyLottoInput {
    private final long amount;

    public BuyLottoInput(long amount) {
        this.amount = amount;
    }

    public Money toMoney() {
        return new Money(this.amount);
    }
}
