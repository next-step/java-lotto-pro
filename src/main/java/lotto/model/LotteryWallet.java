package lotto.model;

import java.util.Optional;

public class LotteryWallet {
	private final Money budget;
	private final Lottos lottosAuto;
	private final Lottos lottosMenual;


	public LotteryWallet(String strMoney, Lottos menual) {
		budget = new Money(strMoney);
		int possiblePurchase = budget.getNumberOfPurchaseAvailable();
		lottosMenual = Optional.ofNullable(menual).orElse(new Lottos(0));
		if (lottosMenual.size() > possiblePurchase) {
			throw new IllegalArgumentException("구매가능한 로또의 개수를 초과했습니다. - 금액 : "+strMoney+" / 수동구매 로또개수: "+lottosMenual.size());
		}
		lottosAuto = new Lottos(possiblePurchase - lottosMenual.size());
	}


	/**
	 * 구매한 로또 총 개수
	 * @return 구매한 로또 총 개수
	 */
	public int numberOfPurchasedLottoTotal() {
		return numberOfPurchasedLottoAuto() + numberOfPurchasedLottoMenual();
	}


	/**
	 * 자동 구매한 로또 개수
	 * @return 자동 구매한 로또 개수
	 */
	public int numberOfPurchasedLottoAuto() {
		return lottosAuto.size();
	}


	/**
	 * 수동 구매한 로또 개수
	 * @return 수동 구매한 로또 개수
	 */
	public int numberOfPurchasedLottoMenual() {
		return lottosMenual.size();
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
		return lottosMenual.toString() + "\n" + lottosAuto.toString();
	}

	/**
	 * 가지고 있는 로또의 당첨결과 반환
	 * @param winningLottoNumbers 로또 당첨 번호
	 * @return 당첨 결과 객체
	 */
	public WinningLottoStatus getWinningStatus(WinningLottoNumbers winningLottoNumbers) {
		//return lottosAuto.getWinningStatus(winningLottoNumbers);
		return WinningLottoStatus.merge(lottosMenual.getWinningStatus(winningLottoNumbers), lottosAuto.getWinningStatus(winningLottoNumbers));
	}
}
