package study.lotto.domain.draw;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private static class DivisionRule {
        private final Map<Boolean, List<Division>> values;

        DivisionRule() {
            this.values = new HashMap<>();
        }

        void add(Division division, Boolean matchBonus) {
            if (!values.containsKey(matchBonus)) {
                values.put(matchBonus, new ArrayList<>());
            }
            addElement(division, matchBonus);
        }

        Division check(int matchCount, boolean matchBonus) {
            return values.get(matchBonus).stream()
                    .filter(division -> division.hasSameMatchCount(matchCount))
                    .findFirst()
                    .orElse(DIVISION_NONE);
        }

        void addElement(Division division, Boolean matchBonus) {
            List<Division> divisions = values.get(matchBonus);
            divisions.add(division);
        }
    }
}
