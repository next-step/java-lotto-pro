package lotto.domain;

import java.util.Objects;

public class LottoResult {
	private final Lotto lotto;
	private final int matchCount;

	public LottoResult(Lotto lotto, WinNumbers winNumbers) {
		this.lotto = lotto;
		this.matchCount = winNumbers.countMatches(lotto);
	}

	public boolean hasMatchCount(int matchCount) {
		return this.matchCount == matchCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoResult that = (LottoResult)o;
		return matchCount == that.matchCount && Objects.equals(lotto, that.lotto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lotto, matchCount);
	}
}
