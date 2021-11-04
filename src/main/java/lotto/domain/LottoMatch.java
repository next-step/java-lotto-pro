package lotto.domain;

import java.util.Objects;

public class LottoMatch {

    private final Rank lottoRank;

    public LottoMatch(LottoNumber matchLotto, LottoNumber lotto) {
        this.lottoRank = Rank.of(matchLotto.getLottoNumber(), lotto.getLottoNumber());
    }

    public boolean isMatch(Rank rank) {
        return this.lottoRank.equals(rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMatch that = (LottoMatch) o;
        return lottoRank == that.lottoRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoRank);
    }

}
