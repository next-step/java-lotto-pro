package lotto.domain;

import lotto.view.OutputView;

import java.math.BigInteger;
import java.util.Objects;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
        validNegative();
    }

    public static Money of(String inputMoney) {
        try {
            BigInteger money = new BigInteger(inputMoney);
            return new Money(money.intValueExact());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_INPUT_ONLY_NUMBER);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_INPUT_AMOUNT_EXCESS);
        }
    }

    private void validNegative() {
        if (money < 0) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_NEGATIVE_NUMBER);
        }
    }

    public int remainder(int value) {
        return this.money % value;
    }

    public int divide(int value) {
        return this.money / value;
    }

    public boolean isLessThanLottoPrice() {
        return this.money < LottoPurchaseAmount.LOTTO_PRICE;
    }

    public double calculateEarningRatio(long earningAmount) {
        return (double) earningAmount / this.money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
