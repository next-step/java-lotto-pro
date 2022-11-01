package lotto.domain.match.count;

import java.util.Objects;

import lotto.domain.amount.Amount;
import lotto.domain.amount.MatchRank;
import lotto.domain.lotto.Lotto;

public class MatchCount {
	private static final int MIN_MATCH_COUNT = 0;

	private final int matchCount;

	private MatchCount(int matchCount) {
		validateRange(matchCount);
		this.matchCount = matchCount;
	}

	public static MatchCount from(int matchCount) {
		return new MatchCount(matchCount);
	}

	private void validateRange(int matchCount) {
		if (matchCount < MIN_MATCH_COUNT) {
			throw new IllegalArgumentException("일치 횟수는 0보다 작을 수 없습니다.");
		}

		if (matchCount > Lotto.LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException("일치 횟수는 로또 숫자 갯수보다 클 수 없습니다.");
		}
	}

	public Amount winningPrice() {
		return MatchRank.getWinningPrice(this);
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
