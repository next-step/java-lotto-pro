package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoGame lottoGame;

    public LottoController(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public void startLotto() {
        LottoTickets lottoTickets = lottoGame.buy(InputView.getLottoPurchasePrice());
        OutputView.lottoPurchaseCount(lottoTickets.ticketCount());
        OutputView.lottoPurchasePrint(lottoTickets.toString());
    }
}
