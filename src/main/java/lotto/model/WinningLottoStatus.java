package lotto.model;

import java.util.Map;

public class WinningLottoStatus {
	private final Map<LottoResult, Integer> winningLottoCount;

	public WinningLottoStatus(Map<LottoResult, Integer> winningLottoCount) {
		this.winningLottoCount = winningLottoCount;
	}

	/**
	 * 당첨된 로또 개수 반환
	 * @param result 당첨종류(LottoResult enum값)
	 * @return 해당 당첨의 개수반환
	 */
	public int getMatchCount(LottoResult result) {
		return winningLottoCount.get(result);
	}

	/**
	 * 당첨된 총 상금 반환
	 * @return 총 상금
	 */
	public int getTotalReward() {
		int totalReward = 0;
		for (Map.Entry<LottoResult, Integer> entry: winningLottoCount.entrySet()) {
			totalReward += entry.getKey().getReward() * entry.getValue();
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
		StringBuffer sbStatus = new StringBuffer();
		sbStatus.append("3개 일치 (").append(LottoResult.MATCH_THREE).append(")- ").append(getMatchCount(LottoResult.MATCH_THREE)).append("개\n");
		sbStatus.append("4개 일치 (").append(LottoResult.MATCH_FOUR).append(")- ").append(getMatchCount(LottoResult.MATCH_FOUR)).append("개\n");
		sbStatus.append("5개 일치 (").append(LottoResult.MATCH_FIVE).append(")- ").append(getMatchCount(LottoResult.MATCH_FIVE)).append("개\n");
		sbStatus.append("6개 일치 (").append(LottoResult.MATCH_SIX).append(")- ").append(getMatchCount(LottoResult.MATCH_SIX)).append("개");
		return sbStatus.toString();
	}
}
