package com.example.lotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatistic {
	private final long purchaseAmount;
	private final Map<LottoRank, Long> lottoRankToCount;

	public LottoStatistic(long purchaseAmount, LottoGames lottoGames, WinningLottoNumbers winningLottoNumbers) {
		this.purchaseAmount = purchaseAmount;
		this.lottoRankToCount = defaultLottoRankToCount();
		addResultsToLottoRankToCount(lottoGames, winningLottoNumbers);
	}

	private Map<LottoRank, Long> defaultLottoRankToCount() {
		Map<LottoRank, Long> map = new TreeMap<>(Comparator.comparingInt(LottoRank::getValue).reversed());
		List<LottoRank> lottoRanksExceptMiss = Arrays.stream(LottoRank.values())
			.filter(lottoRank -> !lottoRank.isMiss())
			.collect(Collectors.toList());

		for (LottoRank lottoRank : lottoRanksExceptMiss) {
			map.put(lottoRank, 0L);
		}

		return map;
	}

	private void addResultsToLottoRankToCount(LottoGames lottoGames, WinningLottoNumbers winningLottoNumbers) {
		this.lottoRankToCount.putAll(lottoGames.getValues().stream()
			.map(lottoGame -> lottoGame.rank(winningLottoNumbers))
			.filter(lottoRank -> !lottoRank.isMiss())
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
	}

	private long getTotalWinningMoney() {
		return lottoRankToCount.entrySet().stream()
			.map(entry -> entry.getKey().getWinningMoney() * entry.getValue())
			.reduce(Long::sum)
			.get();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("당첨 통계\n---------\n");
		for (LottoRank lottoRank : lottoRankToCount.keySet()) {
			Long count = lottoRankToCount.get(lottoRank);
			sb.append(String.format("%s- %d개\n", lottoRank, count));
		}

		sb.append(String.format("총 수익률은 %f입니다.", ((double)getTotalWinningMoney() / purchaseAmount)));
		return sb.toString();
	}
}
