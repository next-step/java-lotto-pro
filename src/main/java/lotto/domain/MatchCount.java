package lotto.domain;

import java.util.Objects;

public class MatchCount {
	private final int matchCount;

	private MatchCount(int matchCount) {
		this.matchCount = matchCount;
	}

	public static MatchCount from(int matchCount) {
		return new MatchCount(matchCount);
	}

	public int getInt() {
		return this.matchCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MatchCount that = (MatchCount)o;
		return matchCount == that.matchCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matchCount);
	}
}
