package model;

public class MatchResult {
	private int threeMatchCount;
	private int fourMatchCount;
	private int fiveMatchCount;
	private int sixMatchCount;

	public MatchResult(int threeMatchCount, int fourMatchCount, int fiveMatchCount, int sixMatchCount) {
		this.threeMatchCount = threeMatchCount;
		this.fourMatchCount = fourMatchCount;
		this.fiveMatchCount = fiveMatchCount;
		this.sixMatchCount = sixMatchCount;
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
}
