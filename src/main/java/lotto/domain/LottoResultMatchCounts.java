package lotto.domain;

public class LottoResultMatchCounts {
	private final LottoResults lottoResults;
	private final int matchCount;

	private LottoResultMatchCounts(LottoResults lottoResults, int matchCount) {
		this.lottoResults = lottoResults;
		this.matchCount = matchCount;
	}

	public static LottoResultMatchCounts from(LottoResults lottoResults, int matchCount) {
		return new LottoResultMatchCounts(lottoResults, matchCount);
	}

	public long getPrice() {
		return 0;
	}

	public int getQuantity() {
		return lottoResults.getQuantity();
	}
}
