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

	public int numberOfPurchasedLotto() {
		return lottos.size();
	}

	public int getUsedMoney() {
		return budget.getUsedMoney();
	}

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
