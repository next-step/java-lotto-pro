package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoResults {
	private final List<LottoResult> lottoResults;

	private LottoResults(List<LottoResult> lottoResults) {
		this.lottoResults = lottoResults;
	}

	public static LottoResults from(List<LottoResult> lottoResults) {
		return new LottoResults(lottoResults);
	}

	public LottoResultMatchCounts toLottoResultMatchCounts(MatchCount matchCount) {
		return LottoResultMatchCounts.from(
			filterByMatchCount(matchCount),
			matchCount
		);
	}

	private LottoResults filterByMatchCount(MatchCount matchCount) {
		return new LottoResults(
			this.lottoResults.stream()
				.filter(lottoResult -> lottoResult.hasMatchCount(matchCount))
				.collect(Collectors.toList())
		);
	}

	public WinningPrices toWinningPrices() {
		return WinningPrices.from(
		this.lottoResults.stream()
			.map(LottoResult::winningPrice)
			.collect(Collectors.toList())
		);
	}

	public WinningPrice totalWinningPrice() {
		return this.toWinningPrices().totalPrice();
	}

	public int quantity() {
		return this.lottoResults.size();
	}

	public float yield() {
		return totalWinningPrice().div(quantity());
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
