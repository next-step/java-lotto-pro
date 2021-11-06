package com.example.lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatistic {
	private final PurchaseInformation purchaseInformation;
	private final Map<LottoRank, Long> lottoRankToCount;

	private LottoStatistic(PurchaseInformation purchaseInformation, Map<LottoRank, Long> lottoRankToCount) {
		this.purchaseInformation = purchaseInformation;
		this.lottoRankToCount = lottoRankToCount;
	}

	static LottoStatistic of(
		PurchaseInformation purchaseInformation,
		LottoGames lottoGames,
		WinningLottoNumbers winningLottoNumbers
	) {
		Map<LottoRank, Long> lottoRankToCount = defaultStatistic();
		lottoRankToCount.putAll(getStatistic(lottoGames, winningLottoNumbers));

		return new LottoStatistic(purchaseInformation, lottoRankToCount);
	}

	private static Map<LottoRank, Long> defaultStatistic() {
		Map<LottoRank, Long> map = new TreeMap<>(Comparator.comparingInt(LottoRank::getValue).reversed());
		List<LottoRank> lottoRanksExceptMiss = Arrays.stream(LottoRank.values())
			.filter(lottoRank -> !lottoRank.isMiss())
			.collect(Collectors.toList());

		for (LottoRank lottoRank : lottoRanksExceptMiss) {
			map.put(lottoRank, 0L);
		}

		return map;
	}

	private static Map<LottoRank, Long> getStatistic(
		LottoGames lottoGames,
		WinningLottoNumbers winningLottoNumbers
	) {
		return lottoGames.getValues().stream()
			.map(lottoGame -> lottoGame.rank(winningLottoNumbers))
			.filter(lottoRank -> !lottoRank.isMiss())
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	private long getTotalWinningMoney() {
		return lottoRankToCount.entrySet().stream()
			.map(entry -> entry.getKey().getWinningMoney() * entry.getValue())
			.reduce(Long::sum)
			.get();
	}

	double getEarningsRate() {
		return (double)getTotalWinningMoney() / purchaseInformation.getActualPurchaseMoney();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("당첨 통계\n---------\n");
		for (LottoRank lottoRank : lottoRankToCount.keySet()) {
			Long count = lottoRankToCount.get(lottoRank);
			sb.append(String.format("%s- %d개\n", lottoRank, count));
		}

		sb.append(String.format("총 수익률은 %f입니다.", getEarningsRate()));
		return sb.toString();
	}
}
