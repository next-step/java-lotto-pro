package lottoservice.matcher;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lottoservice.lottoticket.LottoTicketIssuer;

public class LottoMatchResult {

	private static int TWO_DECIMAL_FORMAT = 100;
	private Map<LottoMatchRank, Integer> result;

	public LottoMatchResult() {
		this.result = initResultSet();
	}

	/* LinkedHashMap으로 순서 보장 */
	private Map<LottoMatchRank, Integer> initResultSet() {
		return Stream.of(LottoMatchRank.values())
			.collect(Collectors.toMap(entry -> entry, entry -> 0, (o1, o2) -> o1, LinkedHashMap::new));
	}

	public void addMatchCount(LottoMatchRank lottoMatchRank) {
		result.put(lottoMatchRank, result.getOrDefault(lottoMatchRank, 0) + 1);
	}

	public Map<LottoMatchRank, Integer> getResult() {
		return result;
	}

	public int getRankMatchCount(LottoMatchRank lottoMatchRank) {
		return result.get(lottoMatchRank);
	}

	/* 상금 합계 */
	public long calculateProfit() {
		return result.entrySet().stream()
			.mapToLong(entry -> entry.getKey().getWinningMoney() * entry.getValue())
			.sum();
	}

	/* 비용 대비 상금으로 수익률 계산 = 상금 합계 / (구매한 티켓 갯수 * 티켓 단위 금액) */
	public double calculateProfitPercentage() {
		long profit = calculateProfit() * TWO_DECIMAL_FORMAT;
		long dividedProfit = profit / (getNumOfMatchResults() * LottoTicketIssuer.TICKET_PER_PRICE);
		return (double)dividedProfit / TWO_DECIMAL_FORMAT;
	}

	/* HashMap의 size() 메서드를 사용하면 key의 갯수를 구하기 때문에 map을 탐색하여 각각의 비교 결과 합을 구해야 함*/
	private int getNumOfMatchResults() {
		return result.entrySet()
			.stream()
			.mapToInt(matchResult -> matchResult.getValue())
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
