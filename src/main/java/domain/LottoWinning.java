package domain;

import java.util.Arrays;

public enum LottoWinning {
    FIRST_PRIZE(MatchRule.of(6, 6, false), 2000000000),
    SECOND_PRIZE(MatchRule.of(5, 5, true), 30000000),
    THIRD_PRIZE(MatchRule.of(5, 5, false), 1500000),
    FOURTH_PRIZE(MatchRule.of(4, 4, false), 50000),
    FIFTH_PRIZE(MatchRule.of(3, 3, false), 5000),
    NONE(MatchRule.of(0, 2, false), 0);

    private final MatchRule matchRule;
    private final int prize;

    LottoWinning(MatchRule matchRule, int prize) {
        this.matchRule = matchRule;
        this.prize = prize;
    }

    public static LottoWinning of(int numberMatchSize, boolean isBonusNumberMatched) {
        return Arrays.stream(LottoWinning.values())
            .filter(l -> l.matchRule.contains(numberMatchSize))
            .filter(l -> l.matchRule.isBonusConditionMatched(isBonusNumberMatched))
            .findFirst()
            .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }

    public int getMaxNumberMatched() {
        return matchRule.getMaxNumberMatched();
    }

    static class MatchRule {
        private final int minCountOfMatch;
        private final int maxCountOfMatch;
        private final boolean isBonusNumberMatchRequired;

        public static MatchRule of(int minMatched, int maxMatched, boolean isBonusNumberMatched) {
            return new MatchRule(minMatched, maxMatched, isBonusNumberMatched);
        }

        public boolean contains(int countOfMatched) {
            return countOfMatched >= minCountOfMatch && countOfMatched <= maxCountOfMatch;
        }

        public boolean isBonusConditionMatched(boolean isBonusNumberMatched) {
            if (isBonusNumberMatchRequired) {
                return isBonusNumberMatched;
            }
            return true;
        }

        private MatchRule(int minCountOfMatch, int maxCountOfMatch, boolean isBonusNumberMatchRequired) {
            this.minCountOfMatch = minCountOfMatch;
            this.maxCountOfMatch = maxCountOfMatch;
            this.isBonusNumberMatchRequired = isBonusNumberMatchRequired;
        }

        public int getMaxNumberMatched() {
            return maxCountOfMatch;
        }
    }
}
