package study.lotto.domain.draw;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public enum Division {
    DIVISION_NONE(0, BigDecimal.ZERO, null),
    DIVISION_FIVE(3, new BigDecimal(5_000), null),
    DIVISION_FOUR(4, new BigDecimal(5_0000), null),
    DIVISION_THREE(5, new BigDecimal(1_500_000), false),
    DIVISION_TWO(5, new BigDecimal(30_000_000), true),
    DIVISION_ONE(6, new BigDecimal(2_000_000_000), null);

    private final int matchCount;
    private final BigDecimal prize;
    private final Boolean bonusMatch;

    Division(int matchCount, BigDecimal prize, Boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonusMatch = bonusMatch;
    }

    public static Division valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(division -> division.hasSameMatchCount(matchCount))
                .filter(division -> division.checkBonusMatch(matchBonus))
                .findFirst()
                .orElse(DIVISION_NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public boolean getBonusMandatory() {
        return Boolean.TRUE.equals(bonusMatch);
    }

    private boolean hasSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    private boolean checkBonusMatch(boolean bonusMatch) {
        if (Objects.isNull(this.bonusMatch)) {
            return true;
        }
        return this.bonusMatch == bonusMatch;
    }
}
