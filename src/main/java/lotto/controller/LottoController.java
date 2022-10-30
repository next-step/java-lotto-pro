package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTickets;
import lotto.domain.WinningLottoNumbers;
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

        List<Integer> winningLottoNumberList = new WinningLottoNumbers(InputView.getLastWeekWinningNumber()).getLottoNumbers();
        int bonusNumber = InputView.getBonusNumber();
//        System.out.println(bonusNumber);
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningLottoNumberList);

        lottoGame.makeLottoResult(winningLottoNumbers, lottoTickets);

        ResultView.winningResult(lottoGame.winningResult());
        ResultView.StatisticsPercent(lottoGame.statisticsPercent(purchasePrice));
    }

}
