package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import lotto.view.LottoWinPrize;
import money.Money;

public class LottoWinResults {

	private final Map<LottoWinPrize, Integer> winPrizesCounts = new ConcurrentHashMap<>();

	private LottoWinResults() {
	}

	public static LottoWinResults computeWinResult(List<Integer> lottoMatchCounts) {
		LottoWinResults lottoWinResults = new LottoWinResults();

		for (LottoWinPrize winPrize : LottoWinPrize.values()) {
			int matchCount = getMatchCountOfPrize(lottoMatchCounts, winPrize.matchCount);
			lottoWinResults.add(winPrize, matchCount);
		}

		return lottoWinResults;
	}

	private static int getMatchCountOfPrize(List<Integer> matchCounts, int matchCount) {
		return (int)matchCounts.stream()
			.filter(count -> count == matchCount).count();
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoWinResults that = (LottoWinResults)o;
		return winPrizesCounts.equals(that.winPrizesCounts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(winPrizesCounts);
	}
}
