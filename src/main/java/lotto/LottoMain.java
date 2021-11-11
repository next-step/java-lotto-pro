package lotto;

import lotto.model.Lottos;
import lotto.model.PurchaseMoney;
import lotto.model.WinLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
	public static void main(String[] args) {
		PurchaseMoney money = InputView.getMoney();
		Lottos lottos = ResultView.purchaseLottos(money);
		WinLotto winLotto = InputView.getWinLotto();
		ResultView.printResult(lottos.winPrize(winLotto), money);
	}
}
