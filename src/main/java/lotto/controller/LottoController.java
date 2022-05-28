package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void buy() {
        Money money = new Money(InputView.inputBuyAmount(), InputView.inputManualCount());
        Lottos lottos = InputView.inputManualNumbers(money.buyManualCount());
        lottos.merge(new Lottos(money.buyCount() - money.buyManualCount()));
        ResultView.printLottoNumbers(lottos);

        Lotto winningLotto = new Lotto(InputView.inputWinningNumbers());
        LottoNo bonusLottoNo = new LottoNo(InputView.inputBonusNumbers());
        Organizer organizer = new Organizer(winningLotto, bonusLottoNo);
        ResultView.printWinningResult(organizer.winningResults(lottos));
        ResultView.printRateOfReturn(organizer.winningRate(money.receiveAmount()));
    }
}
