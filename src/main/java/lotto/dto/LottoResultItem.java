package lotto.dto;

import lotto.Match;

import java.util.Objects;

public class LottoResultItem {
    private final Match match;
    private final int prizeMoney;
    private final int count;

    public LottoResultItem(Match match, int prizeMoney, int count) {
        this.match = match;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public Match getMatch() {
        return match;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResultItem that = (LottoResultItem) o;
        return prizeMoney == that.prizeMoney && count == that.count && match.equals(that.match);
    }

    @Override
    public int hashCode() {
        return Objects.hash(match, prizeMoney, count);
    }
}
