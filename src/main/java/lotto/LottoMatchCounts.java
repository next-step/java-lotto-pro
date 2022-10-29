package lotto;

import java.util.List;
import java.util.Objects;

import utils.CollectionUtils;

public class LottoMatchCounts {

	private final List<Integer> matchCounts;

	private LottoMatchCounts(List<Integer> matchCounts) {
		this.matchCounts = matchCounts;
	}

	public static LottoMatchCounts of(List<Integer> equalNumbersCount) {
		return new LottoMatchCounts(equalNumbersCount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoMatchCounts that = (LottoMatchCounts)o;
		return CollectionUtils.isEqualInAnyOrder(matchCounts, that.matchCounts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(matchCounts);
	}

	public int getMatchCount(int matchCount) {
		return (int)matchCounts.stream()
			.filter(count -> count == matchCount).count();
	}

	public int getLottoPurchaseCount() {
		return matchCounts.size();
	}
}
