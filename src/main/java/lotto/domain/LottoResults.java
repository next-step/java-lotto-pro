package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {
	private final List<LottoResult> lottoResults;

	private LottoResults(List<LottoResult> lottoResults) {
		this.lottoResults = lottoResults;
	}

	public static LottoResults from(List<LottoResult> lottoResults) {
		return new LottoResults(lottoResults);
	}

	public LottoResults filterByMatchCount(int matchCount) {
		return new LottoResults(
			this.lottoResults.stream()
				.filter(lottoResult -> lottoResult.hasMatchCount(matchCount))
				.collect(Collectors.toList())
		);
	}

	public int getQuantity() {
		return this.lottoResults.size();
	}

	public long getPrice() {
		return 0;
	}

	public float winningPrice() {
		return 0;
	}
}
