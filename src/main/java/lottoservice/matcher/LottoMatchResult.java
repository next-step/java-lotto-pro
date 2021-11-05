package lottoservice.matcher;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMatchResult {

	private Map<LottoMatchRank, Integer> result;

	public LottoMatchResult() {
		this.result = initResultSet();
	}

	/* LinkedHashMap으로 순서 보장 */
	private Map<LottoMatchRank, Integer> initResultSet() {
		return Arrays.stream(LottoMatchRank.values()).collect(() -> new LinkedHashMap<LottoMatchRank, Integer>(),
			(matches, rank) -> matches.put(rank, 0),
			(matches1, matches2) -> matches1.putAll(matches2));
	}

	public void addCount(LottoMatchRank lottoMatchRank) {
		result.put(lottoMatchRank, result.getOrDefault(lottoMatchRank, 0) + 1);
	}

	public Map<LottoMatchRank, Integer> getResult() {
		return result;
	}

	public long calculateProfit() {
		return result.entrySet().stream()
			.map(rank -> rank.getKey().getWinningMoney() * rank.getValue())
			.mapToLong(profit -> profit)
			.sum();
	}

	public double calculateProfitPercentage() {
		long profit = calculateProfit() * 100; // 소수점 세번째 자리에서 반올림 하는 포맷팅을 위해
		long dividedProfit = profit / (getNumOfMatchResults() * 1000);
		return (double)dividedProfit / 100;
	}

	/* HashMap의 size() 메서드를 사용하면 key의 갯수를 구하기 때문에 map을 탐색하여 각각의 비교 결과 합을 구해야 함*/
	public int getNumOfMatchResults() {
		return result.entrySet()
			.stream()
			.map(matchResult -> matchResult.getValue())
			.mapToInt(numOfResults -> numOfResults)
			.sum();
	}

	@Override
	public String toString() {
		return result.entrySet().stream()
			.filter(matchResult -> matchResult.getKey().getWinningMoney() > 0)
			.map(matchResult -> matchResult.getKey().getCountOfMatch() + "개 일치 ("
				+ matchResult.getKey().getWinningMoney() + "원)- "
				+ matchResult.getValue() + "개")
			.collect(Collectors.joining("\n"));
	}
}
