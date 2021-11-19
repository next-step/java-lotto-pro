package lotto.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO_SIZE = 0;
    private static final int MIN_MONEY = 0;

    private final long money;

    public Money(long money) {
        validateNotNegative(money);
        this.money = money;
    }

    private void validateNotNegative(long money) {
        if (isNegativeNumber(money)) {
            throw new LottoException(LottoErrorCode.INVALID_MONEY);
        }
    }

    private boolean isNegativeNumber(long number) {
        return number < MIN_MONEY;
    }

    public static EarningRate calculateEarningRate(List<Money> monies) {
        if (monies.size() == ZERO_SIZE) {
            return EarningRate.ZERO;
        }

        long sum = monies.stream()
            .mapToLong(Money::getMoney)
            .sum();

        return new EarningRate(BigDecimal.valueOf((double)sum / monies.size() / LOTTO_PRICE));
    }

    public long getMoney() {
        return money;
    }

    public TicketCount calculateCount() {
        return new TicketCount(money / LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Money)) {
            return false;
        }
        Money that = (Money)o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
