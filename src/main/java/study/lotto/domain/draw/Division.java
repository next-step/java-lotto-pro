package study.lotto.domain.draw;

import java.math.BigDecimal;

public enum Division {
    DIVISION_NONE(0, BigDecimal.ZERO, false),
    DIVISION_FIVE(3, new BigDecimal(5_000), false),
    DIVISION_FOUR(4, new BigDecimal(5_0000), false),
    DIVISION_THREE(5, new BigDecimal(1_500_000), false),
    DIVISION_TWO(5, new BigDecimal(30_000_000), true),
    DIVISION_ONE(6, new BigDecimal(2_000_000_000), false);

    private static final DivisionRule rule = new DivisionRule();

    static {
        rule.add(Division.DIVISION_ONE, false);
        rule.add(Division.DIVISION_TWO, true);
        rule.add(Division.DIVISION_THREE, false);
        rule.add(Division.DIVISION_FOUR, true);
        rule.add(Division.DIVISION_FOUR, false);
        rule.add(Division.DIVISION_FIVE, true);
        rule.add(Division.DIVISION_FIVE, false);
    }

    private final int matchCount;
    private final BigDecimal prize;
    private final boolean bonusMandatory;

    Division(int matchCount, BigDecimal prize, boolean bonusMandatory) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonusMandatory = bonusMandatory;
    }

    public static Division valueOf(int matchCount, boolean matchBonus) {
        return rule.check(matchCount, matchBonus);
    }

    public boolean hasSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public boolean getBonusMandatory() {
        return bonusMandatory;
    }
}
