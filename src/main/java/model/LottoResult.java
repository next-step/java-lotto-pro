package model;

import java.util.Objects;

public class LottoResult {
	private int matchingCount;

	public LottoResult() {
		this.matchingCount = 0;
	}

	public void addMatchingCount() {
		matchingCount++;
	}

	public Rank getRank(boolean isMatchBonusNumber) {
		return Rank.mapByMatchingCountAndBonusFlag(matchingCount, isMatchBonusNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoResult that = (LottoResult)o;
		return matchingCount == that.matchingCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matchingCount);
	}
}
