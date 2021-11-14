package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        Price price = inputView.getPrice();
        Lottos lottos = new Lottos(price);
        outputView.printLottos(lottos);
        WinningNumbers winningNumbers = inputView.getWinningNumbers();
        WinningStats winningStats = new WinningStats(lottos, winningNumbers);
        ProfitRate profitRate = price.getProfitRate(winningStats);
        outputView.printWinningStats(winningStats);
        outputView.printProfitRate(profitRate);
    }
}
