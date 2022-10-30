package step3.model;

import step3.constant.ErrorMessageConstant;
import step3.exception.LottoFormatException;

import java.util.Objects;

public class Money implements Comparable<Money> {

    private double money;

    public Money(String text) {
        int money = convertNumber(text);
        checkOutOfSize(money);
        this.money = money;
    }

    public Money(double money) {
        checkOutOfSize(money);
        this.money = money;
    }

    private int convertNumber(String text) {
        int result;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new LottoFormatException(ErrorMessageConstant.NOT_NUMBER);
        }
        return result;
    }

    private void checkOutOfSize(double number) {
        if (number < 0) {
            throw new LottoFormatException(ErrorMessageConstant.NEGATIVE_NUMBER);
        }
    }

    public boolean isLessThan(Money otherMoney) {
        return this.money < otherMoney.money;
    }

    public int divide(Money otherMoney) {
        return (int) money / (int) otherMoney.money;
    }

    public double getPercent(Money otherMoney) {
        return money / otherMoney.money;
    }

    public void plus(Money otherMoney) {
        this.money += otherMoney.money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money that = (Money) o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public int compareTo(Money o) {
        return Double.compare(this.money, o.money);
    }

    @Override
    public String toString() {
        return Double.toString(money);
    }
}
