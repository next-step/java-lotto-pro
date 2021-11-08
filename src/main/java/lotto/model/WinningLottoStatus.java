package lotto.model;

import java.util.Map;

public class WinningLottoStatus {
	private final Map<Rank, Integer> winningLottoCount;

	public WinningLottoStatus(Map<Rank, Integer> winningLottoCount) {
		this.winningLottoCount = winningLottoCount;
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
		StringBuffer sbStatus = new StringBuffer();
		sbStatus.append(String.format("3개 일치(%d원)- %d개\n" ,Rank.FIFTH.getWinningMoney(), getMatchCount(Rank.FIFTH)));
		sbStatus.append(String.format("4개 일치(%d원)- %d개\n" ,Rank.FOURTH.getWinningMoney(), getMatchCount(Rank.FOURTH)));
		sbStatus.append(String.format("5개 일치(%d원)- %d개\n" ,Rank.THIRD.getWinningMoney(), getMatchCount(Rank.THIRD)));
		sbStatus.append(String.format("5개 일치, 보너스 볼 일치(%d원)- %d개\n" ,Rank.SECOND.getWinningMoney(), getMatchCount(Rank.SECOND)));
		sbStatus.append(String.format("6개 일치(%d원)- %d개\n" ,Rank.FIRST.getWinningMoney(), getMatchCount(Rank.FIRST)));
		return sbStatus.toString();
	}
}
