package lotto.model;

import java.util.HashMap;
import java.util.Map;

import lotto.code.RankCode;

public class LottoResult {

	private static final int DEFAULT_VALUE = 0;
	private static final int COUNT_VALUE = 1;

	public int containsWinningLottoNumbers(WinningLottoNumbers winningLottoNumbers, LottoNumbers lottoNumbers) {
		int containsCount = 0;

		for (LottoNumber lottoNumber : lottoNumbers.lottoNumberList) {
			containsCount += winningLottoNumbers.containsCountLottoNumber(lottoNumber);
		}

		return containsCount;
	}

	public Map<Integer, Integer> containsWinningLottoGenerator(WinningLottoNumbers winningLottoNumbers,
		LottoGenerator lottoGenerator) {
		Map<Integer, Integer> containsMap = new HashMap<>();

		for (LottoNumbers lottoNumbers : lottoGenerator.getLottoNumbersList()) {
			int containsCount = containsWinningLottoNumbers(winningLottoNumbers, lottoNumbers);
			containsMap.put(containsCount, containsMap.getOrDefault(containsCount, DEFAULT_VALUE) + COUNT_VALUE);
		}

		return containsMap;
	}

	public RankCode getRankCodeUsingContainsCount(int contains) {
		return RankCode.getRankCode(contains);
	}

	public RankCode getRankCodeUsingContainsCount(WinningLottoNumbers winningLottoNumbers, LottoNumbers lottoNumbers) {
		int contains = containsWinningLottoNumbers(winningLottoNumbers, lottoNumbers);
		return RankCode.getRankCode(contains);
	}

	public Map<RankCode, Integer> getRankCodeMapUsingContainsMap(WinningLottoNumbers winningLottoNumbers,
		LottoGenerator lottoGenerator) {
		Map<Integer, Integer> containsMap = containsWinningLottoGenerator(winningLottoNumbers, lottoGenerator);
		Map<RankCode, Integer> rankMap = new HashMap<>();

		for (Map.Entry<Integer, Integer> containsEntry : containsMap.entrySet()) {
			RankCode key = getRankCodeUsingContainsCount(containsEntry.getKey());
			rankMap.put(key, rankMap.getOrDefault(key, DEFAULT_VALUE) + containsEntry.getValue());
		}

		return rankMap;
	}

	public double calculateYield(WinningLottoNumbers winningLottoNumbers, LottoGenerator lottoGenerator) {
		int sum = DEFAULT_VALUE;
		Map<RankCode, Integer> rankMap = getRankCodeMapUsingContainsMap(winningLottoNumbers, lottoGenerator);

		for (Map.Entry<RankCode, Integer> rankCodeEntry : rankMap.entrySet()) {
			sum += RankCode.getRankMoney(rankCodeEntry.getKey(), rankCodeEntry.getValue());
		}

		return (double)sum / lottoGenerator.getInputMoney();
	}
}
