package lotto.dto;

import java.util.Objects;

public class LottoResultItem {
    private final int match;
    private final int prizeMoney;
    private final int count;

    public LottoResultItem(int match, int prizeMoney, int count) {
        this.match = match;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public int getMatch() {
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
        return match == that.match && prizeMoney == that.prizeMoney && count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(match, prizeMoney, count);
    }
}
