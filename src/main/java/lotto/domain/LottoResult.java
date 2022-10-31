package lotto.domain;

import java.util.Objects;

public class LottoResult {
	private final Lotto lotto;
	private final MatchCount matchCount;

	private LottoResult(Lotto lotto, MatchCount matchCount) {
		this.lotto = lotto;
		this.matchCount = matchCount;
	}

	public static LottoResult from(Lotto lotto, MatchCount matchCount) {
		return new LottoResult(lotto, matchCount);
	}

	public boolean hasMatchCount(MatchCount matchCount) {
		return this.matchCount.equals(matchCount);
	}

	public Amount winningPrice() {
		return matchCount.winningPrice();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoResult that = (LottoResult)o;
		return Objects.equals(lotto, that.lotto) && Objects.equals(matchCount, that.matchCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotto, matchCount);
	}
}
