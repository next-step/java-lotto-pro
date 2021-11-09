package lotto;

import lotto.constants.LottoConstants;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
	public static void main(String[] args) {
		Lottos lottos = InputView.purchaseLottos();
		Lotto winLotto = InputView.getWinLotto();
		LottoGame game = new LottoGame(winLotto);
		ResultView.printResult(game.winPrize(lottos), lottos.size() * LottoConstants.PRICE);
	}
}
