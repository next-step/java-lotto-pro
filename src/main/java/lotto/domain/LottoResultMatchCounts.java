package lotto.domain;

public class LottoResultMatchCounts {
	private final LottoResults lottoResults;
	private final MatchCount matchCount;

	private LottoResultMatchCounts(LottoResults lottoResults, MatchCount matchCount) {
		this.lottoResults = lottoResults;
		this.matchCount = matchCount;
	}

	public static LottoResultMatchCounts from(LottoResults lottoResults, MatchCount matchCount) {
		return new LottoResultMatchCounts(lottoResults, matchCount);
	}

	public LottoResultMessage getResultMessage() {
		int matchQuantity = this.lottoResults.quantity();
		return new LottoResultMessage(this.matchCount, matchQuantity, WinningPrice.from(this.matchCount));
	}
}
