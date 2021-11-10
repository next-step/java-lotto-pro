package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
	private final Map<Rank, Integer> lottoResult;

	public LottoResult(final Map<Rank, Integer> lottoResult) {
		this.lottoResult = new EnumMap<Rank, Integer>(lottoResult);
	}

	public int countWinner(Rank rank) {
		return lottoResult.getOrDefault(rank, 0);
	}

	public int countLotto() {
		return lottoResult.values()
			.stream()
			.mapToInt(Integer::intValue)
			.sum();
	}
}
