package lotto;

import lotto.model.Lottos;
import lotto.model.PurchaseMoney;
import lotto.model.WinLotto;
import lotto.util.LottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
	public static void main(String[] args) {
		PurchaseMoney money = InputView.getMoney();
		int numberOfManualLotto = InputView.getNumberManualLotto();
		Lottos lottos = LottoGenerator.purchaseLottos(money.countAutoLottoSize(numberOfManualLotto));
		Lottos manualLottos = InputView.getManualLottos(numberOfManualLotto);

		lottos = lottos.merge(manualLottos);

		ResultView.printPurchasedLottos(numberOfManualLotto, lottos);

		WinLotto winLotto = InputView.getWinLotto();
		ResultView.printResult(lottos.winPrize(winLotto), money);
	}
}
