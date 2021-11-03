package lotto.controller;

import lotto.domain.BoughtLotto;

import static lotto.view.ConsoleView.outputBoughtLotto;

public class LottoExecutor {

    private final LottoController lottoController;

    public LottoExecutor() {
        this.lottoController = LottoController.getInstance();
    }

    public void run() {
        BoughtLotto boughtLotto = lottoController.buyLotto();
        outputBoughtLotto(boughtLotto.getBoughtCount());
    }
}
