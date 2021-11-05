package lotto.model;

import java.util.HashMap;
import java.util.Map;

import lotto.code.RankCode;

public class LottoResult {

	private static final int DEFAULT_VALUE = 0;
	private static final int COUNT_VALUE = 1;

	private final WinningLottoNumbers winningLottoNumbers;
	private final LottoGenerator lottoGenerator;

	public LottoResult() {
		this.winningLottoNumbers = new WinningLottoNumbers();
		this.lottoGenerator = new LottoGenerator();
	}

	public LottoResult(WinningLottoNumbers winningLottoNumbers, LottoGenerator lottoGenerator) {
		this.winningLottoNumbers = winningLottoNumbers;
		this.lottoGenerator = lottoGenerator;
	}

	public int containsWinningLottoNumbers(WinningLottoNumbers winningLottoNumbers, LottoNumbers lottoNumbers) {
		int containsCount = 0;

		for (LottoNumber lottoNumber : lottoNumbers.lottoNumberList) {
			containsCount += winningLottoNumbers.containsCountLottoNumber(lottoNumber);
		}

		return containsCount;
	}

	public Map<Integer, Integer> containsWinningLottoGenerator() {
		Map<Integer, Integer> containsMap = new HashMap<>();

		for (LottoNumbers lottoNumbers : this.lottoGenerator.getLottoNumbersList()) {
			int containsCount = containsWinningLottoNumbers(this.winningLottoNumbers, lottoNumbers);
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

	public Map<RankCode, Integer> getRankCodeMapUsingContainsMap() {
		Map<RankCode, Integer> rankMap = RankCode.generateRankCodeMap();

		for (Map.Entry<Integer, Integer> containsEntry : containsWinningLottoGenerator().entrySet()) {
			RankCode key = getRankCodeUsingContainsCount(containsEntry.getKey());
			rankMap.put(key, rankMap.get(key) + containsEntry.getValue());
		}

		return rankMap;
	}

	public double calculateYield() {
		int sum = DEFAULT_VALUE;
		Map<RankCode, Integer> rankMap = getRankCodeMapUsingContainsMap();

		for (Map.Entry<RankCode, Integer> rankCodeEntry : rankMap.entrySet()) {
			sum += RankCode.getRankMoney(rankCodeEntry.getKey(), rankCodeEntry.getValue());
		}

		return (double)sum / lottoGenerator.getInputMoney();
	}
}
