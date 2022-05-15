package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoGroups;
import lotto.domain.Money;
import lotto.view.InputView;

public class LottoGameController {
    private final LottoGame lottoGame;

    public LottoGameController() {
        String inputMoney = InputView.inputMoney();
        Money money = new Money(inputMoney);
        LottoGroups lottoGroups = new LottoGroups(money.calculateLottoCount());
        lottoGame = new LottoGame(lottoGroups, money);
    }

    public void playGame() {
        lottoGame.playGame();
    }
}
