package lotto.controller;

import java.util.Scanner;

import lotto.model.LotteryWallet;
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
	}

	private void showPurchasedLotto(LotteryWallet wallet) {
		view.printlnPurchasedLottoResult(wallet);
	}

	private LotteryWallet purchaseLotto() {
		view.printlnInputMoney();
		LotteryWallet wallet = null;
		do {
			wallet = makeWallet();
		} while(wallet == null || wallet.numberOfPurchasedLotto() == 0);
		return wallet;
	}

	private LotteryWallet makeWallet() {
		try {
			String money = scan.nextLine();
			return new LotteryWallet(money);
		} catch (IllegalArgumentException e) {
			view.printlnError(e);
		}
		return null;
	}
}
