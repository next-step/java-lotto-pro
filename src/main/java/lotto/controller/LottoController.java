package lotto.controller;

import java.util.Scanner;

import lotto.model.LotteryWallet;
import lotto.model.WinningLottoNumbers;
import lotto.model.WinningLottoStatus;
import lotto.view.LottoView;

public class LottoController {
	private LottoView view = new LottoView();
	private Scanner scan = new Scanner(System.in);

	/**
	 * 프로그램 시작
	 */
	public void run() {
		lottoStart();
	}

	/**
	 * 로또 시작
	 */
	private void lottoStart() {
		LotteryWallet wallet = purchaseLotto();
		showPurchasedLotto(wallet);
		WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbers();
		WinningLottoStatus winningLottoStatus = wallet.getWinningStatus(winningLottoNumbers);
		showWinningLottoStatus(winningLottoStatus, wallet);
	}

	private void showWinningLottoStatus(WinningLottoStatus winningLottoStatus, LotteryWallet wallet) {
		view.printlnBlank();
		view.printlnWinningLottoStatus(winningLottoStatus);
		view.printlnWinningLottoRateOfReturn(winningLottoStatus, wallet.getUsedMoney());
	}

	/**
	 * 로또 당첨 번호 획득 프로세스
	 * @return 로또 당첨 번호
	 */
	private WinningLottoNumbers getWinningLottoNumbers() {
		WinningLottoNumbers winningLottoNumbers = null;
		do {
			winningLottoNumbers = makeWinningLottoNumbers();
		} while(winningLottoNumbers == null);
		return winningLottoNumbers;
	}

	/**
	 * 당첨번호를 입력받아 로또 당첨 번호를 생성
	 * @return 로또당첨번호
	 */
	private WinningLottoNumbers makeWinningLottoNumbers() {
		try {
			view.printlnInputWinningLottoNumbers();
			String numbers = scan.nextLine();
			view.printlnInputWinningBonusNumber();
			String bonusNumber = scan.nextLine();
			return new WinningLottoNumbers(numbers, bonusNumber);
		} catch (IllegalArgumentException e) {
			view.printlnError(e);
		}
		return null;
	}

	/**
	 * 구매결과(로또지갑상태) 출력
	 * @param wallet 로또 지갑
	 */
	private void showPurchasedLotto(LotteryWallet wallet) {
		view.printlnPurchasedLottoResult(wallet);
		view.printlnBlank();
	}

	/**
	 * 로또 구매 프로세스
	 * @return 로또 지갑
	 */
	private LotteryWallet purchaseLotto() {
		view.printlnInputMoney();
		LotteryWallet wallet = null;
		do {
			wallet = makeWallet();
		} while(wallet == null || wallet.numberOfPurchasedLottoTotal() == 0);
		return wallet;
	}

	/**
	 * 금액을 입력받아 로또 지갑 생성
	 * @return 로또 지갑
	 */
	private LotteryWallet makeWallet() {
		try {
			String money = scan.nextLine();
			return new LotteryWallet(money, null);
		} catch (IllegalArgumentException e) {
			view.printlnError(e);
		}
		return null;
	}
}
