package model;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

public final class Score {

	private static final int PLUS_COUNT_SIZE = 1;
	private static final int INITIAL_COUNT = 0;
	private final EnumMap<LottoRank, Integer> rankCount;

	private Score(Collection<LottoRank> lottoRanks) {
		validate(lottoRanks);
		this.rankCount = calculateCount(lottoRanks);
	}

	static Score from(Collection<LottoRank> lottoRanks) {
		return new Score(lottoRanks);
	}

	public int count(LottoRank rank) {
		return rankCount.get(rank);
	}

	public Money prizeMoney() {
		int sum = 0;
		for (Map.Entry<LottoRank, Integer> entry : rankCount.entrySet()) {
			sum += entry.getKey().multipliedPrizeMoney(entry.getValue());
		}
		return Money.from(sum);
	}

	private void validate(Collection<LottoRank> lottoRanks) {
		if (isEmpty(lottoRanks)) {
			throw new IllegalArgumentException("'lottoRanks' must not be empty");
		}
	}

	private boolean isEmpty(Collection<LottoRank> lottoRanks) {
		return lottoRanks == null || lottoRanks.isEmpty();
	}

	private EnumMap<LottoRank, Integer> calculateCount(Collection<LottoRank> lottoRanks) {
		EnumMap<LottoRank, Integer> count = initializedCounts();
		for (LottoRank rank : lottoRanks) {
			count.put(rank, count.get(rank) + PLUS_COUNT_SIZE);
		}
		return count;
	}

	private EnumMap<LottoRank, Integer> initializedCounts() {
		EnumMap<LottoRank, Integer> counts = new EnumMap<>(LottoRank.class);
		for (LottoRank rank : LottoRank.values()) {
			counts.putIfAbsent(rank, INITIAL_COUNT);
		}
		return counts;
	}
}
