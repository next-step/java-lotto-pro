package study.temp.lotto.auto;

import java.util.Objects;

public class MatchCount {

    private int matchOfCount;
    private boolean bonusBall;

    public MatchCount() {
    }

    public MatchCount(int matchOfCount) {
        this.matchOfCount = matchOfCount;
        this.bonusBall = false;
    }

    public MatchCount(int matchOfCount, boolean bonusBall) {
        this(matchOfCount);
        this.bonusBall = bonusBall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MatchCount that = (MatchCount) o;
        return matchOfCount == that.matchOfCount && bonusBall == that.bonusBall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchOfCount, bonusBall);
    }
}
