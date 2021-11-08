package lotto.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class LotteryWallet {
	private Money budget;
	private Lottos lottos;

	public LotteryWallet(String strMoney) {
		budget = new Money(strMoney);
		int possiblePurchase = budget.getNumberOfPurchaseAvailable();
		lottos = new Lottos(possiblePurchase);
	}

	/**
	 * 구매한 로또 개수
	 * @return 구매한 로또 개수
	 */
	public int numberOfPurchasedLotto() {
		return lottos.size();
	}

	/**
	 * 실제 로또구매에 사용한 금액
	 * @return 실제 로또구매에 사용한 금액
	 */
	public int getUsedMoney() {
		return budget.getUsedMoney();
	}

	/**
	 * 구매한 로또들의 상태 텍스트 반환
	 * @return 로또들의 상태 텍스트
	 */
	public String lottosStatus() {
		return lottos.toString();
	}

	/**
	 * 가지고 있는 로또의 당첨결과 반환
	 * @param winningLottoNumbers 로또 당첨 번호
	 * @return 당첨 결과 객체
	 */
	public WinningLottoStatus getWinningStatus(WinningLottoNumbers winningLottoNumbers) {
		return lottos.getWinningStatus(winningLottoNumbers);
	}
}
