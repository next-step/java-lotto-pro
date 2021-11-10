package lotto.domain;

import java.util.Objects;

public class MatchResult {

    private final int matchCount;
    private final boolean matchBonus;

    private MatchResult(final int matchCount, final boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public static MatchResult from(final int matchCount, final boolean matchBonus) {
        return new MatchResult(matchCount, matchBonus);
    }

    public boolean isResultMatch(final int matchOfCount) {
        if( this.matchCount == matchOfCount ) {
            return true;
        }
        return false;
    }

    public boolean isBonusMatch(boolean bonusMatch) {
        if( this.matchBonus == bonusMatch ) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResult that = (MatchResult) o;
        return matchCount == that.matchCount && matchBonus == that.matchBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, matchBonus);
    }
}
