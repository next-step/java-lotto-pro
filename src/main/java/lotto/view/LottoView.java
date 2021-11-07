package lotto.view;

import lotto.model.LotteryWallet;

public class LottoView {
	public void printlnInputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
	}

	public void printlnError(IllegalArgumentException e) {
		System.out.println("[ERROR] "+e);
	}

	public void printlnPurchasedLottoResult(LotteryWallet wallet) {
		System.out.println(wallet.numberOfPurchasedLotto()+"개를 구매했습니다.");
		System.out.println(wallet.lottosStatus());
	}
}
