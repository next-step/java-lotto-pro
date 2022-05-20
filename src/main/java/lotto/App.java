package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class App {
    public static void main(String[] args) {
        String buyPrice = InputView.getBuyPrice();
        LottoGame lottoGame = new LottoGame(buyPrice);
        lottoGame.buyLottos();
        ResultView.printBuyLottos(lottoGame);

        LottoResult lottoResult = lottoGame.getLottoResult(InputView.getWinningNumbers(), InputView.getBonusNumber());
        ResultView.printWinningResult(lottoResult);
        ResultView.printReturnRate(lottoResult.rateOfReturn(new Money(buyPrice)));
    }
}
