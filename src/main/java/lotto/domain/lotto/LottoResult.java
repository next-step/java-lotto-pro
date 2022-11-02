package lotto.domain.lotto;

import java.util.Objects;

import lotto.domain.amount.Amount;

public class LottoResult {
	private final Lotto lotto;
	private final MatchRank matchRank;

	private LottoResult(Lotto lotto, MatchRank matchRank) {
		this.lotto = lotto;
		this.matchRank = matchRank;
	}

	public static LottoResult from(Lotto lotto, MatchRank matchRank) {
		return new LottoResult(lotto, matchRank);
	}

	public boolean hasMatchRank(MatchRank matchRank) {
		return this.matchRank.equals(matchRank);
	}

	public Amount winningPrice() {
		return Amount.from(this.matchRank.getWinningPrice());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoResult that = (LottoResult)o;
		return Objects.equals(lotto, that.lotto) && Objects.equals(matchRank, that.matchRank);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotto, matchRank);
	}
}
