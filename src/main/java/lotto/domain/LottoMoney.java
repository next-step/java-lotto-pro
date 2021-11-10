package lotto.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class LottoMoney {
    private static final int LOTTO_PRICE = 1000;
    private static final String WON = "원";
    private static final int ZERO_SIZE = 0;
    private static final int MIN_MONEY = 0;

    private long money;

    public LottoMoney(long money) {
        this.money = money;
    }

    public LottoMoney(String money) {
        this.money = parseToValidMoney(money);
    }

    private long parseToValidMoney(String moneyText) {
        long money = parseToNumber(moneyText);
        if (isNegativeNumber(money)) {
            throw new LottoException(LottoErrorCode.INVALID_MONEY);
        }

        return money;
    }

    private long parseToNumber(String money) {
        try {
            return Long.parseLong(money);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorCode.INVALID_MONEY);
        }
    }

    private boolean isNegativeNumber(long number) {
        return number < MIN_MONEY;
    }

    public static EarningRate calculateEarningRate(List<LottoMoney> lottoMonies) {
        if (lottoMonies.size() == ZERO_SIZE) {
            return EarningRate.ZERO;
        }

        long sum = lottoMonies.stream()
            .mapToLong(lottoMoney -> lottoMoney.money)
            .sum();

        return new EarningRate(BigDecimal.valueOf((double)sum / lottoMonies.size() / LOTTO_PRICE));
    }

    public LottoCount calculateLottoCount() {
        return new LottoCount(money / LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoMoney)) {
            return false;
        }
        LottoMoney that = (LottoMoney)o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    public String makePrintableMessage() {
        return money + WON;
    }
}
