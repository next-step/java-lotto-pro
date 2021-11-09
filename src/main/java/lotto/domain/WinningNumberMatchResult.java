package lotto.domain;

import java.util.Objects;

public class WinningNumberMatchResult {

    private int winningNumberMatchCount;
    private boolean matchBonus;

    public WinningNumberMatchResult(int winningNumberMatchCount, boolean matchBonus) {
        this.winningNumberMatchCount = winningNumberMatchCount;
        this.matchBonus = matchBonus;
    }

    public Rank rank() {
        return Rank.of(winningNumberMatchCount, matchBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumberMatchResult that = (WinningNumberMatchResult) o;
        return winningNumberMatchCount == that.winningNumberMatchCount && matchBonus == that.matchBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumberMatchCount, matchBonus);
    }
}
