package lotto.controller;

import lotto.domain.BoughtLotto;
import lotto.domain.LottoTicket;
import lotto.domain.Winning;

import static lotto.view.ConsoleView.*;

public class LottoExecutor {

    private final LottoController lottoController;

    public LottoExecutor() {
        this.lottoController = LottoController.getInstance();
    }

    public void run() {
        BoughtLotto boughtLotto = lottoController.buyLotto();
        printBoughtLotto(boughtLotto.getBoughtCount());
        LottoTicket lottoTicket = lottoController.generateLottoTicket(boughtLotto);
        printLottoTicket(lottoTicket);
        printLine();
        Winning winningLottoNumbers = lottoController.enterWinningLottoNumbers();
        printLine();
    }
}
