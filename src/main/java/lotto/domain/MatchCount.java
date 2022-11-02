package lotto.domain;

import java.util.Objects;

public class MatchCount implements Comparable<MatchCount> {

    private static final int NUMBERS_WITH_BONUS = 5;
    private final int matchBallCount;
    private final boolean isMatchBonusBall;

    public MatchCount(final int matchBallCount, final boolean isMatchBonusBall) {
        this.matchBallCount = matchBallCount;
        this.isMatchBonusBall = isMatchBonusBall;
    }

    public int getMatchBallCount() {
        return matchBallCount;
    }

    @Override
    public int compareTo(final MatchCount matchCount) {
        int compare = Integer.compare(this.matchBallCount, matchCount.matchBallCount);
        if(compare == 0) {
            return Boolean.compare(this.isMatchBonusBall, matchCount.isMatchBonusBall);
        }
        return compare;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final MatchCount that = (MatchCount) o;
        if (matchBallCount == NUMBERS_WITH_BONUS) {
            return Objects.equals(matchBallCount, that.matchBallCount)
                    && Objects.equals(isMatchBonusBall, that.isMatchBonusBall);
        }
        return Objects.equals(matchBallCount, that.matchBallCount);
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + matchBallCount;
        return result;
    }
}
