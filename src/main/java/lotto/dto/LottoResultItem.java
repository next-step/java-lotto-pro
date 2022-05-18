package lotto.dto;

import lotto.domain.Match;
import lotto.domain.Rank;

import java.util.Objects;

public class LottoResultItem {
    private final Rank rank;
    private final int count;

    public LottoResultItem(Rank rank, int count) {
        this.rank = rank;
        this.count = count;
    }

    public Rank getRank() {
        return rank;
    }

    public Match getMatch() {
        return rank.getMatch();
    }

    public int getPrizeMoney() {
        return rank.getPrize();
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResultItem that = (LottoResultItem) o;
        return count == that.count && rank == that.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, count);
    }
}
