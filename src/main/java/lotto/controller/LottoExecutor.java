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
        BoughtLotto boughtLotto = enterPayment();
        LottoTicket lottoTicket = generateLotto(boughtLotto);
        Winning winning = enterWinningNumber();
        WinningMap winningMap = winningResult(lottoTicket, winning);
        printRevenue(calculateRevenue(winningMap, boughtLotto));
    }

    private BoughtLotto enterPayment() {
        BoughtLotto boughtLotto = lottoController.buyLotto();
        printBoughtLotto(boughtLotto.getBoughtCount());
        return boughtLotto;
    }

    private LottoTicket generateLotto(BoughtLotto boughtLotto) {
        LottoTicket lottoTicket = lottoController.generateLottoTicket(boughtLotto);
        printLottoTicket(lottoTicket);
        printLine();
        return lottoTicket;
    }

    private Winning enterWinningNumber() {
        Winning winning = lottoController.enterWinningLottoNumbers();
        printLine();
        return winning;
    }

    private WinningMap winningResult(LottoTicket lottoTicket, Winning winning) {
        WinningMap winningMap = WinningMap.winningOf(lottoTicket, winning);
        printWinning(winningMap);
        return winningMap;
    }

    private double calculateRevenue(WinningMap winningMap, BoughtLotto boughtLotto) {
        return winningMap.revenue(boughtLotto);
    }


}
