package model;

import java.util.Objects;

public class MatchResult {
	private int threeMatchCount;
	private int fourMatchCount;
	private int fiveMatchCount;
	private int sixMatchCount;

	public MatchResult() {
	}

	MatchResult(int threeMatchCount, int fourMatchCount, int fiveMatchCount, int sixMatchCount) {
		this.threeMatchCount = threeMatchCount;
		this.fourMatchCount = fourMatchCount;
		this.fiveMatchCount = fiveMatchCount;
		this.sixMatchCount = sixMatchCount;
	}

	public void increaseByMatchCount(int matchCount) {
		if (matchCount == 3) {
			threeMatchCount++;
			return;
		}
		if (matchCount == 4) {
			fourMatchCount++;
			return;
		}
		if (matchCount == 5) {
			fiveMatchCount++;
			return;
		}
		if (matchCount == 6) {
			sixMatchCount++;
			return;
		}
	}

	public int getThreeMatchCount() {
		return threeMatchCount;
	}

	public int getFourMatchCount() {
		return fourMatchCount;
	}

	public int getFiveMatchCount() {
		return fiveMatchCount;
	}

	public int getSixMatchCount() {
		return sixMatchCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MatchResult that = (MatchResult)o;
		return threeMatchCount == that.threeMatchCount && fourMatchCount == that.fourMatchCount
			&& fiveMatchCount == that.fiveMatchCount && sixMatchCount == that.sixMatchCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(threeMatchCount, fourMatchCount, fiveMatchCount, sixMatchCount);
	}
}
