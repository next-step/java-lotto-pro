package step3.model.machine;

import java.util.Objects;
import step3.model.value.Rule;

public class Match {

    private final int matchCount;
    private final int matchBonusCount;

    public Match(int matchCount, int matchBonusCount) {

        this.matchCount = matchCount;
        this.matchBonusCount = matchBonusCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Match)) {
            return false;
        }
        final Match that = (Match) o;
        if(matchCount == Rule.BONUS_COUNT_NUMBER){
            return Objects.equals(matchCount, that.matchCount)
                    && Objects.equals(matchBonusCount, that.matchBonusCount);
        }
        return Objects.equals(matchCount, that.matchCount);
    }

    @Override
    public int hashCode() {
        final int HASH_PRIME = 31;
        int result = 1;
        result = HASH_PRIME * result + matchCount;
        return result;
    }

    @Override
    public String toString() {
        return matchCount+","+matchBonusCount;
    }
}
