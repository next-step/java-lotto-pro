package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.factory.LottoFactory;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class App {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.getBuyPrice());
        lottoGame.buyLottos();
        ResultView.printBuyLottos(lottoGame);

        LottoResult lottoResult = lottoGame.getLottoResult(InputView.getWinningNumbers());
        ResultView.printWinningResult(lottoResult);

    }
}
