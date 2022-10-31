package lotto.prize;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Prize {
    FIRST(6, BigDecimal.valueOf(2000000000)),
    SECOND(5, BigDecimal.valueOf(30000000)),
    THIRD(5, BigDecimal.valueOf(1500000)),
    FOURTH(4, BigDecimal.valueOf(50000)),
    FIFTH(3, BigDecimal.valueOf(5000)),
    MISS(0, BigDecimal.ZERO);

    private final int matchCount;
    private final BigDecimal prizeMoney;

    Prize(int matchCount, BigDecimal prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize prizeOf(int matchCount, boolean isBonusMatch) {
        return Arrays.stream(Prize.values())
                .filter(v -> v.matchCount == matchCount)
                .map(v -> {
                    if (Prize.THIRD.matchCount == matchCount) {
                        return Prize.checkThirdOrSecond(matchCount, isBonusMatch);
                    }
                    return v;
                })
                .findFirst()
                .orElse(Prize.MISS);
    }

    private static Prize checkThirdOrSecond(int matchCount, boolean isBonusMatch) {
        if (isBonusMatch) {
            return Prize.SECOND;
        }
        return Prize.THIRD;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }

}
