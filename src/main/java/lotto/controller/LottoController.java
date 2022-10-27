package lotto.controller;

import lotto.domain.LottoGame;
import lotto.view.InputView;

public class LottoController {

    public void startLotto() {
        System.out.println("LottoController.startLotto");
        LottoGame lottoGame = new LottoGame(InputView.getLottoPurchasePrice());

    }
}
