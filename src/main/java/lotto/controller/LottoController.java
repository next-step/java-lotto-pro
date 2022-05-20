package lotto.controller;

import lotto.model.Cashier;
import lotto.model.Lottos;
import lotto.model.Organizer;
import lotto.model.Store;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void buy() {
        Cashier cashier = new Cashier(InputView.inputBuyAmount());
        Store store = new Store(cashier.buyCount());
        Lottos lottos = store.giveLotto();
        ResultView.printLottoNumbers(lottos);

        Organizer organizer = new Organizer(InputView.inputWinningNumbers());
        ResultView.printWinningResult(organizer.winningResults(lottos));
        ResultView.printRateOfReturn(organizer.winningRate(cashier.receiveAmount()));
    }
}
