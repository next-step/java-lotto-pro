package lotto;

import java.util.List;
import java.util.Objects;

import utils.CollectionUtils;

public class LottoWinResult {

	private final List<Integer> equalNumbersCount;

	private LottoWinResult(List<Integer> equalNumbersCount) {
		this.equalNumbersCount = equalNumbersCount;
	}

	public static LottoWinResult of(List<Integer> equalNumbersCount) {
		return new LottoWinResult(equalNumbersCount);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoWinResult that = (LottoWinResult)o;
		return CollectionUtils.isEqualInAnyOrder(equalNumbersCount, that.equalNumbersCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(equalNumbersCount);
	}
}
