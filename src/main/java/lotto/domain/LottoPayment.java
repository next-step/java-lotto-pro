package lotto.domain;

import static lotto.domain.LottoCondition.TICKET_COST;
import static lotto.domain.message.ErrorMessage.INVALID_MANUAL_AMOUNT;
import static lotto.domain.message.ErrorMessage.INVALID_PAYMENT;

import java.util.Objects;
import lotto.service.ManualAmountValidator;
import lotto.service.MoneyValidator;
import lotto.util.StringToIntegerConverter;

public class LottoPayment {
    private final int money;
    private final int purchasableAmount;
    private int manualAmount = 0;

    LottoPayment(final int money, final int purchasableAmount) {
        this.money = money;
        this.purchasableAmount = purchasableAmount;
    }

    public static LottoPayment convertAndCreate(final String moneyString) {
        final int money = StringToIntegerConverter.parseInt(moneyString, INVALID_PAYMENT);
        MoneyValidator.validate(money);
        return new LottoPayment(money, money / TICKET_COST.getCondition());
    }

    public int getMoney() {
        return money;
    }

    public int getPurchasableAmount() {
        return purchasableAmount;
    }

    public int getManualAmount() {
        return manualAmount;
    }

    public void setManualAmount(final String manualAmountString) {
        final int manualAmount = StringToIntegerConverter.parseInt(manualAmountString, INVALID_MANUAL_AMOUNT);
        ManualAmountValidator.validate(manualAmount, purchasableAmount);
        this.manualAmount = manualAmount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "money=" + money +
                ", purchasableAmount=" + purchasableAmount +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoPayment lottoPayment = (LottoPayment) o;
        return money == lottoPayment.money && purchasableAmount == lottoPayment.purchasableAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, purchasableAmount);
    }
}
