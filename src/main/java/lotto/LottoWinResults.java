package lotto;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import money.Money;
import view.LottoWinPrize;

public class LottoWinResults {

	private final Map<LottoWinPrize, Integer> winPrizesCounts = new ConcurrentHashMap<>();

	private LottoWinResults() {
	}

	public static LottoWinResults computeWinResult(LottoMatchCounts lottoMatchCounts) {
		LottoWinResults lottoWinResults = new LottoWinResults();

		for (LottoWinPrize winPrize : LottoWinPrize.values()) {
			int matchCount = lottoMatchCounts.getMatchCount(winPrize.matchCount);
			lottoWinResults.add(winPrize, matchCount);
		}

		return lottoWinResults;
	}

	public ProfitMargin getProfitMargin(Money lottoPrice) {
		Money totalPrizesMoney = getTotalPrizesMoney();
		return ProfitMargin.valueOf(totalPrizesMoney.divideBy(getTotalPurchaseAmount(lottoPrice)));
	}

	private Money getTotalPurchaseAmount(Money purchaseAmount) {
		return purchaseAmount.multiply(getLottoPurchaseCounts());
	}

	private Money getTotalPrizesMoney() {
		return winPrizesCounts.entrySet()
			.stream()
			.map(entry -> entry.getKey().prize.multiply(entry.getValue()))
			.reduce(Money.ZERO, Money::add);
	}

	private void add(LottoWinPrize winPrize, int matchCount) {
		winPrizesCounts.merge(winPrize, matchCount, Integer::sum);
	}

	public int getWinPrizeCount(LottoWinPrize threeMatches) {
		return winPrizesCounts.get(threeMatches);
	}

	private int getLottoPurchaseCounts() {
		return winPrizesCounts.values()
			.stream()
			.mapToInt(Integer::intValue)
			.sum();
	}
}
