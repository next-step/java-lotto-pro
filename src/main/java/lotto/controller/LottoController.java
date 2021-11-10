package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.model.LotteryWallet;
import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.WinningLottoNumbers;
import lotto.model.WinningLottoStatus;
import lotto.view.LottoView;

public class LottoController {
	private final LottoView view = new LottoView();
	private final Scanner scan = new Scanner(System.in);

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
		view.printlnBlank();
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
			view.printlnBlank();
			return new LotteryWallet(money, getManualLottos());
		} catch (IllegalArgumentException e) {
			view.printlnError(e);
		}
		return null;
	}

	/**
	 * 수동 입력 로또 구매
	 * @return 수동 입력 로또
	 */
	private Lottos getManualLottos() {
		List<Lotto> manualLottoList = new ArrayList<>();
		int manualLottoCount = getManualLottoCount();
		view.printlnBlank();
		view.printlnPurchasedManualLotto();
		for (int i = 0; i < manualLottoCount; i++) {
			manualLottoList.add(getManualLotto());
		}
		return new Lottos(manualLottoList);
	}

	/**
	 * 수동 입력 로또 개수 입력
	 * @return 수동 입력 로또 개수
	 */
	private int getManualLottoCount() {
		view.printlnInputManualLottoCount();
		return Integer.parseUnsignedInt(scan.nextLine());
	}

	/**
	 * 수동 입력 로또 가져오기
	 * @return 수동 입력으로 생성된 로또
	 */
	private Lotto getManualLotto() {
		Lotto lotto = null;
		do {
			lotto = makeLotto();
		} while(lotto == null);
		return lotto;
	}

	private Lotto makeLotto() {
		try {
			String lottoNumbers = scan.nextLine();
			return new Lotto(new LottoNumbers(lottoNumbers));
		} catch (IllegalArgumentException e) {
			view.printlnError(e);
		}
		return null;
	}
}
