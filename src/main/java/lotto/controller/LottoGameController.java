package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;

public class LottoGameController {
    private final LottoGame lottoGame;

    public LottoGameController() {
        String receivedMoney = InputView.inputMoney();
        Money money = new Money(receivedMoney);
        LottoTickets lottoTickets = new LottoTickets(money.calculateLottoTicketCount());
        lottoGame = new LottoGame(lottoTickets, money);
    }

    public void play() {
        lottoGame.play();
    }
}
