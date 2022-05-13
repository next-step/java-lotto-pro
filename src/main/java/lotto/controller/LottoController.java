package lotto.controller;

import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.io.IOException;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void playing() throws IOException {
        long purchasePrice = purchaseLottos();
        createPurchaseLottos(purchasePrice);
        WinningLotto winningLotto = createWinningLotto();
        winningStatistics(purchasePrice, winningLotto);
    }

    private void winningStatistics(long purchasePrice, WinningLotto winningLotto) {
        resultView.printWinningStatisticsTitle();
        resultView.printWinningStatistics(winningLotto);
        resultView.printTotalEarningsRate(winningLotto, purchasePrice);
    }

    private long purchaseLottos() throws IOException {
        return inputView.inputPurchasePrice();
    }

    private void createPurchaseLottos(long purchasePrice) {
        resultView.printPurchaseLottos(new Lottos(purchasePrice));
    }

    private WinningLotto createWinningLotto() throws IOException {
        return new WinningLotto(new LottoNumbers(inputView.inputWinningLottoNumbers()));
    }
}
