package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void startLotto() {
        int money = InputView.getLottoPurchasePrice();
        LottoGame lottoGame = new LottoGame();
        LottoTickets lottoTickets = lottoGame.buy(money);
        OutputView.lottoPurchaseCount(lottoTickets.ticketCount());
    }
}
