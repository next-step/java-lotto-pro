package lotto.domain;

import java.util.Objects;

public class MatchCount {
	private static final int MIN_MATCH_COUNT = 0;
	private static final int MAX_MATCH_COUNT = 6;

	private final int matchCount;

	private MatchCount(int matchCount) {
		validateRange(matchCount);
		this.matchCount = matchCount;
	}

	private void validateRange(int matchCount) {
		if (matchCount < MIN_MATCH_COUNT) {
			throw new IllegalArgumentException("일치 횟수는 0보다 작을 수 없습니다.");
		}

		if (matchCount > MAX_MATCH_COUNT) {
			throw new IllegalArgumentException("일치 횟수는 6보다 클 수 없습니다.");
		}
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
