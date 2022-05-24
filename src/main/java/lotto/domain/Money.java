package lotto.domain;

import java.text.DecimalFormat;
import java.util.Objects;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    private static final String NUMBER_DIGITS = "###,###";

    private final double value;

    public Money() {
        this(0);
    }

    public Money(String money) {
        this(Double.parseDouble(money));
    }

    public Money(double money) {
        this.value = money;
    }

    public boolean lessThenLottoPrice() {
        return value < LOTTO_PRICE;
    }

    public int getQuantity() {
        return (int) (this.value / LOTTO_PRICE);
    }

    public Money sumMoney(Money money) {
        return new Money(money.value + this.value);
    }

    public double calculateRateOfReturn(Money winningMoneySum) {
        return winningMoneySum.value / this.value;
    }

    public String krw() {
        return String.format("₩ %s", new DecimalFormat(NUMBER_DIGITS).format(this.value));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Double.compare(money1.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
