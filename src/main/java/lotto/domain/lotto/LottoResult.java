package lotto.domain.lotto;

import java.util.Objects;

import lotto.domain.amount.Amount;

public class LottoResult {
	private final Lotto lotto;
	private final MatchRank matchRank;

	private LottoResult(Lotto lotto, int matchCount, LottoNumber bonusNumber) {
		validateMatchCount(matchCount);
		this.lotto = lotto;
		this.matchRank = MatchRank.valueOfMatchCount(matchCount, lotto.contains(bonusNumber));
	}

	private void validateMatchCount(int matchCount) {
		if (matchCount < 0) {
			throw new IllegalArgumentException("일치 횟수는 0보다 작을수 없습니다.");
		}
	}

	public static LottoResult from(Lotto lotto, int matchCount, LottoNumber bonusNumber) {
		return new LottoResult(lotto, matchCount, bonusNumber);
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
