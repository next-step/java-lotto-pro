package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void buy() {
        Counter counter = new Counter(InputView.inputBuyAmount());
        Lottos lottos = new Lottos(counter.buyCount());
        ResultView.printLottoNumbers(lottos);

        WinningNumber winningNumber = new WinningNumber(new LottoNumbersInput(InputView.inputWinningNumbers()));
        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumbers(), winningNumber);
        Organizer organizer = new Organizer(winningNumber, bonusNumber);
        ResultView.printWinningResult(organizer.winningResults(lottos));
        ResultView.printRateOfReturn(organizer.winningRate(counter.receiveAmount()));
    }
}
