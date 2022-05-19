package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;

public class LottoGameController {
    private final LottoGame lottoGame;

    public LottoGameController() {
        String receivedMoney = InputView.inputMoney();
        Money money = new Money(receivedMoney);
        lottoGame = new LottoGame(money);
    }

    public void play() {
        lottoGame.play();
    }
}
