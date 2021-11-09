package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

	public static final int DEFAULT_VALUE = 0;
	public static final int COUNT_VALUE = 1;
	public static final double MATH_ROUND_VALUE = 100d;

	private final WinningLottoNumbers winningLottoNumbers;
	private final Lottos lottos;

	private LottoResult(WinningLottoNumbers winningLottoNumbers, Lottos lottos) {
		this.winningLottoNumbers = winningLottoNumbers;
		this.lottos = lottos;
	}

	public static LottoResult of(WinningLottoNumbers winningLottoNumbers, Lottos lottos) {
		return new LottoResult(winningLottoNumbers, lottos);
	}

	public Map<LottoRank, Integer> getRankCodeMapUsingContainsMap() {
		Map<LottoRank, Integer> rankMap = LottoRank.generateRankCodeMap();

		for (Map.Entry<LottoRank, Integer> containsEntry : containsWinningLottoGenerator().entrySet()) {
			rankMap.put(containsEntry.getKey(), rankMap.get(containsEntry.getKey()) + containsEntry.getValue());
		}

		return rankMap;
	}

	private Map<LottoRank, Integer> containsWinningLottoGenerator() {
		Map<LottoRank, Integer> lottoRankMap = new EnumMap<>(LottoRank.class);

		for (LottoNumbers lottoNumbers : lottos.getLottoNumbersList()) {
			LottoRank lottoRank = LottoRank
				.getRankCode(containsWinningLottoNumbers(winningLottoNumbers, lottoNumbers),
					containsBonusLottoNumber(winningLottoNumbers, lottoNumbers));

			lottoRankMap.put(lottoRank, lottoRankMap.getOrDefault(lottoRank, DEFAULT_VALUE) + COUNT_VALUE);
		}

		return lottoRankMap;
	}

	private int containsWinningLottoNumbers(WinningLottoNumbers winningLottoNumbers, LottoNumbers lottoNumbers) {
		int containsCount = 0;

		for (LottoNumber lottoNumber : lottoNumbers.lottoNumberList) {
			containsCount += winningLottoNumbers.containsCountLottoNumber(lottoNumber);
		}

		return containsCount;
	}

	private int containsBonusLottoNumber(WinningLottoNumbers winningLottoNumbers, LottoNumbers lottoNumbers) {
		return winningLottoNumbers.containsBonusCountLottoNumber(lottoNumbers);
	}

	public float calculateSum() {
		float sum = DEFAULT_VALUE;
		Map<LottoRank, Integer> rankMap = containsWinningLottoGenerator();

		for (Map.Entry<LottoRank, Integer> rankCodeEntry : rankMap.entrySet()) {
			sum += LottoRank.getRankMoney(rankCodeEntry.getKey(), rankCodeEntry.getValue());
		}

		return sum;
	}

	public float getYield() {
		return lottos.getInputMoney().calculateYield(calculateSum());
	}
}
