package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

	public static final int DEFAULT_VALUE = 0;
	public static final int COUNT_VALUE = 1;
	public static final double MATH_ROUND_VALUE = 100d;

	private final WinningLottoNumbers winningLottoNumbers;
	private final Lottos lottos;

	public LottoResult(WinningLottoNumbers winningLottoNumbers, Lottos lottos) {
		this.winningLottoNumbers = winningLottoNumbers;
		this.lottos = lottos;
	}

	public Map<Integer, Integer> containsWinningLottoGenerator() {
		Map<Integer, Integer> containsMap = new HashMap<>();

		for (LottoNumbers lottoNumbers : lottos.getLottoNumbersList()) {
			int containsCount = containsWinningLottoNumbers(winningLottoNumbers, lottoNumbers);
			System.out.println(containsCount);
			containsMap.put(containsCount, containsMap.getOrDefault(containsCount, DEFAULT_VALUE) + COUNT_VALUE);
		}

		return containsMap;
	}

	public LottoRank getRankCodeUsingContainsCount(WinningLottoNumbers winningLottoNumbers, LottoNumbers lottoNumbers) {
		int contains = containsWinningLottoNumbers(winningLottoNumbers, lottoNumbers);
		return LottoRank.getRankCode(contains);
	}

	public int containsWinningLottoNumbers(WinningLottoNumbers winningLottoNumbers, LottoNumbers lottoNumbers) {
		int containsCount = 0;

		for (LottoNumber lottoNumber : lottoNumbers.lottoNumberList) {
			containsCount += winningLottoNumbers.containsCountLottoNumber(lottoNumber);
		}

		return containsCount;
	}

	public Map<LottoRank, Integer> getRankCodeMapUsingContainsMap() {
		Map<LottoRank, Integer> rankMap = LottoRank.generateRankCodeMap();

		for (Map.Entry<Integer, Integer> containsEntry : containsWinningLottoGenerator().entrySet()) {
			LottoRank key = getRankCodeUsingContainsCount(containsEntry.getKey());
			rankMap.put(key, rankMap.get(key) + containsEntry.getValue());
		}

		return rankMap;
	}

	public LottoRank getRankCodeUsingContainsCount(int contains) {
		return LottoRank.getRankCode(contains);
	}

	public double calculateYield() {
		double sum = DEFAULT_VALUE;
		Map<LottoRank, Integer> rankMap = getRankCodeMapUsingContainsMap();

		for (Map.Entry<LottoRank, Integer> rankCodeEntry : rankMap.entrySet()) {
			sum += LottoRank.getRankMoney(rankCodeEntry.getKey(), rankCodeEntry.getValue());
		}

		return (Math.round((sum / lottos.getInputMoney() * LottoResult.MATH_ROUND_VALUE))
			/ LottoResult.MATH_ROUND_VALUE);
	}
}
