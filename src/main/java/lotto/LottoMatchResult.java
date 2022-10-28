package lotto;

import java.util.List;
import java.util.Objects;

import utils.CollectionUtils;

public class LottoMatchResult {

	private final List<Integer> equalNumbersCount;

	private LottoMatchResult(List<Integer> equalNumbersCount) {
		this.equalNumbersCount = equalNumbersCount;
	}

	public static LottoMatchResult of(List<Integer> equalNumbersCount) {
		return new LottoMatchResult(equalNumbersCount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoMatchResult that = (LottoMatchResult)o;
		return CollectionUtils.isEqualInAnyOrder(equalNumbersCount, that.equalNumbersCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(equalNumbersCount);
	}

	public int getMatchCount(int matchCount) {
		return (int)equalNumbersCount.stream()
			.filter(count -> count == matchCount).count();
	}
}
