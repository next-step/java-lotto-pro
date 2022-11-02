package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lotto.domain.amount.Amount;
import lotto.domain.amount.Amounts;
import lotto.domain.quantity.Quantity;
import lotto.domain.yield.DefaultYieldStrategy;
import lotto.domain.yield.Yield;

public class LottoResults {
	private final List<LottoResult> lottoResults;

	private LottoResults(List<LottoResult> lottoResults) {
		this.lottoResults = lottoResults;
	}

	public static LottoResults from(List<LottoResult> lottoResults) {
		return new LottoResults(lottoResults);
	}

	public LottoResults filterByMatchRank(MatchRank matchRank) {

		return new LottoResults(
			this.lottoResults.stream()
				.filter(lottoResult -> lottoResult.hasMatchRank(matchRank))
				.collect(Collectors.toList())
		);
	}

	public Amount totalWinningPrice() {
		Amounts amounts = Amounts.from(
			this.lottoResults.stream()
				.map(LottoResult::winningPrice)
				.collect(Collectors.toList())
		);
		return amounts.totalPrice();
	}

	public Quantity quantity() {
		return Quantity.from(this.lottoResults.size());
	}

	public Yield yield(Amount purchaseAmount) {
		return new DefaultYieldStrategy(totalWinningPrice(), purchaseAmount).yield();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoResults that = (LottoResults)o;
		return Objects.equals(lottoResults, that.lottoResults);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoResults);
	}
}
