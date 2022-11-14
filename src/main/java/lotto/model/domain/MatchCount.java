package lotto.model.domain;

import java.util.Objects;

public class MatchCount {

    private int matchCount;
    private int bonusBallCount;

    public MatchCount(int matchCount, int bonusBallCount) {
        this.matchCount = matchCount;
        this.bonusBallCount = bonusBallCount;
    }

    public boolean checkCount(int matchCount, BonusBallMatch bonusCount) {
        return this.matchCount == matchCount
                && (this.bonusBallCount == bonusCount.getBonusCount() || bonusCount == BonusBallMatch.DOES_NOT_MATTER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchCount that = (MatchCount) o;
        return matchCount == that.matchCount && bonusBallCount == that.bonusBallCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, bonusBallCount);
    }
}
