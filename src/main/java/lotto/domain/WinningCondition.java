package lotto.domain;

import java.math.BigDecimal;

public class WinningCondition {

    private final int count;
    private final BigDecimal prizeMoney;

    public WinningCondition(int count, BigDecimal prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }

    public int getCount() {
        return count;
    }
}
