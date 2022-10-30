package lotto.domain;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import money.Money;

public class LottoWinPrizes {

	private final Map<LottoWinPrize, Integer> winPrizesCounts;

	private LottoWinPrizes(Map<LottoWinPrize, Integer> winPrizesCounts) {
		this.winPrizesCounts = winPrizesCounts;
	}

	public static LottoWinPrizes of(LottoWinPrize... lottoWinPrizes) {
		return of(Arrays.stream(lottoWinPrizes).collect(Collectors.toList()));
	}

	public static LottoWinPrizes of(List<LottoWinPrize> lottoWinPrizeList) {
		Map<LottoWinPrize, Integer> collect = lottoWinPrizeList.stream()
			.collect(toMap(identity(), lottoWinPrize -> 1, Integer::sum, ConcurrentHashMap::new));

		return new LottoWinPrizes(collect);
	}

	public ProfitMargin getProfitMargin(Money lottoPrice) {
		Money totalPrizesMoney = getTotalPrizesMoney();
		return ProfitMargin.valueOf(totalPrizesMoney.divideBy(getTotalPurchaseAmount(lottoPrice)));
	}

	public int getWinPrizeCount(LottoWinPrize lottoWinPrize) {
		return winPrizesCounts.getOrDefault(lottoWinPrize, 0);
	}

	private int getLottoPurchaseCounts() {
		return winPrizesCounts.values()
			.stream()
			.mapToInt(Integer::intValue)
			.sum();
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoWinPrizes that = (LottoWinPrizes)o;
		return winPrizesCounts.equals(that.winPrizesCounts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(winPrizesCounts);
	}
}
