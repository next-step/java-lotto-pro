package lotto.controller;

import lotto.domain.*;

import static lotto.view.ConsoleView.*;

public class LottoExecutor {

    private final LottoController lottoController;

    public LottoExecutor(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public void run() {
        BoughtLotto boughtLotto = paymentLotto();
        LottoTicket lottoTicket = generateLotto(boughtLotto);
        LottoNumbers winningNumbers = enterWinningNumber();
        Winning winning = enterWinningBonusNumber(winningNumbers);
        WinningMap winningMap = winningResult(lottoTicket, winning);
        printRevenue(calculateRevenue(winningMap, boughtLotto));
    }

    private BoughtLotto paymentLotto() {
        BoughtLotto boughtLotto = lottoController.buyLotto();
        printLine();
        return boughtLotto;
    }

    private LottoTicket generateLotto(BoughtLotto boughtLotto) {
        LottoTicket lottoTicket = lottoController.generateLottoTicket(boughtLotto);
        printLottoTicket(lottoTicket);
        printLine();
        return lottoTicket;
    }

    private LottoNumbers enterWinningNumber() {
        LottoNumbers winningNumbers = lottoController.enterWinningLottoNumbers();
        return winningNumbers;
    }

    private Winning enterWinningBonusNumber(LottoNumbers winningNumbers) {
        Winning bonusNumber = lottoController.enterWinningBonusNumber(winningNumbers);
        printLine();
        return bonusNumber;
    }

    private WinningMap winningResult(LottoTicket lottoTicket, Winning winningNumbers) {
        WinningMap winningMap = WinningMap.winningOf(lottoTicket, winningNumbers);
        printWinning(winningMap);
        return winningMap;
    }

    private double calculateRevenue(WinningMap winningMap, BoughtLotto boughtLotto) {
        return winningMap.revenue(boughtLotto);
    }


}
