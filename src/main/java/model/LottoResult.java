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

	public Rank getRank() {
		if (matchingCount == 6) {
			return Rank.FIRST;
		}
		if (matchingCount == 5) {
			return Rank.THIRD;
		}
		if (matchingCount == 4) {
			return Rank.FOURTH;
		}
		if (matchingCount == 3) {
			return Rank.FIFTH;
		}

		return Rank.NONE;
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
