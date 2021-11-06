package lotto.model;

import java.util.Objects;

public class MatchCount {
    private final int matchCount;

    public MatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MatchCount other = (MatchCount)obj;
        return matchCount == other.matchCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount);
    }
}
