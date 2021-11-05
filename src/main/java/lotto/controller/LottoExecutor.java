package lotto.controller;

import lotto.domain.BoughtLotto;
import lotto.domain.LottoTicket;
import lotto.domain.Winning;
import lotto.domain.WinningMap;

import static lotto.view.ConsoleView.*;

public class LottoExecutor {

    private final LottoController lottoController;

    public LottoExecutor(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public void run() {
        BoughtLotto boughtLotto = lottoController.buyLotto();
        printBoughtLotto(boughtLotto.getBoughtCount());
        LottoTicket lottoTicket = lottoController.generateLottoTicket(boughtLotto);
        printLottoTicket(lottoTicket);
        printLine();
        Winning winningLottoNumbers = lottoController.enterWinningLottoNumbers();
        printLine();
        WinningMap winningMap = WinningMap.winningOf(lottoTicket, winningLottoNumbers);
        printWinning(winningMap);
        double revenue = winningMap.revenue(boughtLotto);
        printRevenue(revenue);
    }


}
