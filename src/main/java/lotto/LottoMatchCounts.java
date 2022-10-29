package lotto;

import java.util.List;
import java.util.Objects;

import money.Money;
import utils.CollectionUtils;
import view.LottoWinPrize;

public class LottoMatchCounts {

	private final List<Integer> equalNumbersCount;

	private LottoMatchCounts(List<Integer> equalNumbersCount) {
		this.equalNumbersCount = equalNumbersCount;
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

	public Money getTotalProfits() {
		return equalNumbersCount.stream()
			.map(LottoWinPrize::getPrize)
			.reduce(Money.ZERO, Money::add);
	}
}
