package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final LottoGame lottoGame;

    public LottoController(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public void startLotto() {
        int purchasePrice = InputView.getLottoPurchasePrice();
        LottoTickets lottoTickets = lottoGame.buy(purchasePrice);

        ResultView.lottoPurchase(lottoTickets.ticketCount(), lottoTickets.toString());

        LottoNumbers winningLottoNumbers = new LottoNumbers(
                new WinningLottoNumbers(InputView.getLastWeekWinningNumber()).getLottoNumbers());

        lottoGame.makeLottoResult(winningLottoNumbers, lottoTickets);

        ResultView.winningResult(lottoGame.winningResult());
        ResultView.StatisticsPercent(lottoGame.statisticsPercent(purchasePrice));
    }

}
