package lotto.ui.dto;

import lotto.domain.lotto.Matches;

public class MatchingCount implements Comparable<MatchingCount> {
    private final WinningNumberMatch matches;
    private final long count;

    public MatchingCount(Matches matches, long count) {
        this.matches = WinningNumberMatch.valueOf(matches);
        this.count = count;
    }

    @Override
    public String toString() {
        return matches.toStringWithCount(count);
    }

    public boolean isDisplayed() {
        return matches.isDisplayed();
    }

    @Override
    public int compareTo(MatchingCount other) {
        return this.matches.compareTo(other.matches);
    }
}
