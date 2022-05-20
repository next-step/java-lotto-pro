package lotto.domain;

import java.text.DecimalFormat;
import java.util.Objects;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    private static final String NUMBER_DIGITS = "###,###";

    private final double money;

    public Money() {
        this(0);
    }

    public Money(String money) {
        this(Double.parseDouble(money));
    }

    public Money(double money) {
        this.money = money;
    }

    public boolean lessThenLottoPrice() {
        return money < LOTTO_PRICE;
    }

    public int getQuantity() {
        return (int) (this.money / LOTTO_PRICE);
    }

    public Money sumMoney(Money money) {
        return new Money(money.money + this.money);
    }

    public double calculateRateOfReturn(Money winningMoneySum) {
        return winningMoneySum.money / this.money;
    }

    public String krw() {
        return String.format("₩ %s", new DecimalFormat(NUMBER_DIGITS).format(this.money));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Double.compare(money1.money, money) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return Double.toString(money);
    }
}
