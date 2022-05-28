package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void buy() {
        Money money = InputView.inputMoneyAndManualCount();
        Lottos lottos = InputView.inputManualNumbers(money.buyManualCount());
        lottos.merge(new Lottos(money.buyCount() - money.buyManualCount()));
        ResultView.printLottoNumbers(lottos);

        Organizer organizer = InputView.inputOrganizer();
        ResultView.printWinningResult(organizer.winningResults(lottos));
        ResultView.printRateOfReturn(organizer.winningRate(money.receiveAmount()));
    }
}
