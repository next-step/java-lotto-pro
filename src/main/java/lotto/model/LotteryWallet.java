package lotto.model;

import java.util.Optional;

public class LotteryWallet {
	private final Money budget;
	private final Lottos lottosAuto;
	private final Lottos lottosManual;


	public LotteryWallet(String strMoney, Lottos manual) {
		budget = new Money(strMoney);
		int possiblePurchase = budget.getNumberOfPurchaseAvailable();
		lottosManual = Optional.ofNullable(manual).orElse(new Lottos(0));
		if (lottosManual.size() > possiblePurchase) {
			throw new IllegalArgumentException("구매가능한 로또의 개수를 초과했습니다. - 금액 : "+strMoney+" / 수동구매 로또개수: "+lottosManual.size());
		}
		lottosAuto = new Lottos(possiblePurchase - lottosManual.size());
	}


	/**
	 * 구매한 로또 총 개수
	 * @return 구매한 로또 총 개수
	 */
	public int numberOfPurchasedLottoTotal() {
		return numberOfPurchasedLottoAuto() + numberOfPurchasedLottoManual();
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
	public int numberOfPurchasedLottoManual() {
		return lottosManual.size();
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
		return lottosManual.toString() + "\n" + lottosAuto.toString();
	}

	/**
	 * 가지고 있는 로또의 당첨결과 반환
	 * @param winningLottoNumbers 로또 당첨 번호
	 * @return 당첨 결과 객체
	 */
	public WinningLottoStatus getWinningStatus(WinningLottoNumbers winningLottoNumbers) {
		return WinningLottoStatus.merge(lottosManual.getWinningStatus(winningLottoNumbers), lottosAuto.getWinningStatus(winningLottoNumbers));
	}
}
