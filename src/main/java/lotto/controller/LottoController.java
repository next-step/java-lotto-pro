package lotto.controller;

import lotto.*;
import lotto.model.Cashier;
import lotto.model.Lottos;
import lotto.model.Organizer;
import lotto.model.Store;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private static final Store store = new Store(Config.LOTTO_ONE_GAME_PRICE);

    public static void buy() {
        Cashier cashier = new Cashier(InputView.inputBuyAmount());
        Lottos lottos = store.giveLotto(cashier.receiveAmount());
        ResultView.printLottoNumbers(lottos);

        Organizer organizer = new Organizer(InputView.inputWinningNumbers());
        ResultView.printWinningResult(organizer.winningResults(lottos));
        ResultView.printRateOfReturn(organizer.winningRate(cashier.receiveAmount()));
    }
}
