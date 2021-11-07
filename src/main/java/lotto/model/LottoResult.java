package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

	private static final int DEFAULT_VALUE = 0;
	private static final int COUNT_VALUE = 1;
	private static final double MATH_ROUND_VALUE = 100d;

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

	public List<String> convertRankMapToStringList() {
		List<String> rankStringList = new ArrayList<>();
		for (Map.Entry<RankCode, Integer> rankEntry : getRankCodeMapUsingContainsMap().entrySet()) {
			validNothing(rankStringList, rankEntry);
		}
		Collections.sort(rankStringList);

		return rankStringList;
	}

	private String stringBuilderAppend(Map.Entry<RankCode, Integer> rankEntry) {
		RankCode rankCode = rankEntry.getKey();
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder
			.append(RankCode.containsCount(rankCode))
			.append("개 일치 ")
			.append("(")
			.append(RankCode.getMoney(rankCode))
			.append("원)- ")
			.append(rankEntry.getValue())
			.append("개").toString();
	}

	private void validNothing(List<String> rankStringList, Map.Entry<RankCode, Integer> rankEntry) {
		if (rankEntry.getKey() != RankCode.NOTHING) {
			rankStringList.add(stringBuilderAppend(rankEntry));
		}
	}

	public String convertYieldToString() {
		StringBuilder stringBuilder = new StringBuilder();
		double yield = (Math.round((calculateYield() * MATH_ROUND_VALUE)) / MATH_ROUND_VALUE);
		stringBuilder
			.append("총 수익률은 ")
			.append(yield)
			.append("입니다.");
		if (yield < COUNT_VALUE) {
			stringBuilder.append("(기준이 1이기 떄문에 결과적으로 손해라는 의미임)");
		}
		return stringBuilder.toString();
	}
}
