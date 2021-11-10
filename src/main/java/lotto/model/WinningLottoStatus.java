package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLottoStatus {
	private final Map<Rank, Integer> winningLottoCount;

	public WinningLottoStatus(Map<Rank, Integer> winningLottoCount) {
		this.winningLottoCount = winningLottoCount;
	}

	public static WinningLottoStatus merge(WinningLottoStatus status1, WinningLottoStatus status2) {
		Map<Rank, Integer> merged = new HashMap<>();

		EnumSet.allOf(Rank.class)
			.forEach(result -> merged.put(result, status1.getMatchCount(result) + status2.getMatchCount(result)));

		return new WinningLottoStatus(merged);
	}

	/**
	 * 당첨된 로또 개수 반환
	 * @param result 당첨종류(LottoResult enum값)
	 * @return 해당 당첨의 개수반환
	 */
	public int getMatchCount(Rank result) {
		return winningLottoCount.get(result);
	}

	/**
	 * 당첨된 총 상금 반환
	 * @return 총 상금
	 */
	public int getTotalReward() {
		int totalReward = 0;
		for (Map.Entry<Rank, Integer> entry: winningLottoCount.entrySet()) {
			totalReward += entry.getKey().getWinningMoney() * entry.getValue();
		}
		return totalReward;
	}

	/**
	 * 수익율 계산
	 * @param useMoney 사용한 금액
	 * @return 수익률
	 */
	public double getRateOfReturn(int useMoney) {
		return (double)getTotalReward() / useMoney;
	}

	/**
	 * 당첨 상태 반환
	 * @return 상태 정보 텍스트
	 */
	public String status() {
		return Arrays.stream(Rank.values())
			.filter(Rank::isWinning)
			.sorted(Comparator.comparingInt(Rank::getWinningMoney))
			.map(rank -> String.format("%s- %d개", rank.formatedText(), getMatchCount(rank)))
			.collect(Collectors.joining("\n"));
	}
}
