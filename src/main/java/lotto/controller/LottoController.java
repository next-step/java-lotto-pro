package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    private final LottoGame lottoGame;

    public LottoController(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public void startLotto() {
        int purchasePrice = InputView.getLottoPurchasePrice();
        LottoTickets lottoTickets = lottoGame.buy(purchasePrice);

        ResultView.lottoPurchase(lottoTickets.ticketCount(), lottoTickets.toString());

        String winningNumber = InputView.getLastWeekWinningNumber();
        LottoNumber bonusNumber = new LottoNumber(InputView.getBonusNumber());
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumber, bonusNumber);

        lottoGame.makeLottoResult(winningLottoNumbers, lottoTickets);

        ResultView.winningResult(lottoGame.winningResult());
        ResultView.StatisticsPercent(lottoGame.statisticsPercent(purchasePrice));
    }

}
