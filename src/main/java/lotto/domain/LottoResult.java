package lotto.domain;

import java.util.Objects;

public class LottoResult {
    private final int matchAmount;
    private final boolean matchBonus;

    public LottoResult(int matchAmount) {
        this(matchAmount, false);
    }

    public LottoResult(int matchAmount, boolean matchBonus) {
        this.matchAmount = matchAmount;
        this.matchBonus = matchBonus;
    }

    public LottoRankingStatus getResultRankingStatus() {
        return LottoRankingStatus.valueOf(matchAmount, matchBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return matchAmount == that.matchAmount && matchBonus == that.matchBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchAmount, matchBonus);
    }
}
