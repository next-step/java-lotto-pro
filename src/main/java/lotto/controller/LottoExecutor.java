package lotto.controller;

import lotto.domain.BoughtLotto;
import lotto.domain.LottoTicket;

import static lotto.view.ConsoleView.outputBoughtLotto;
import static lotto.view.ConsoleView.outputLottoTicket;

public class LottoExecutor {

    private final LottoController lottoController;

    public LottoExecutor() {
        this.lottoController = LottoController.getInstance();
    }

    public void run() {
        BoughtLotto boughtLotto = lottoController.buyLotto();
        outputBoughtLotto(boughtLotto.getBoughtCount());
        LottoTicket lottoTicket = lottoController.generateLottoTicket(boughtLotto);
        outputLottoTicket(lottoTicket);
    }
}
