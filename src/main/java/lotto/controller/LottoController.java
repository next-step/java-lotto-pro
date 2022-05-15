package lotto.controller;

import lotto.*;
import lotto.model.Lottos;
import lotto.model.Store;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private static final Store store = new Store(Config.LOTTO_ONE_GAME_PRICE);

    public static void buyLotto() {
        int amount = InputView.inputBuyAmount(store.inputAmountText());
        store.receiveAmount(amount);
        Lottos lottos = store.giveLotto();
        ResultView.printLottoNumbers(lottos);
    }

}
