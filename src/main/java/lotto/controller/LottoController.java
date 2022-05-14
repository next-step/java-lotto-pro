package lotto.controller;

import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.io.IOException;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void playing() throws IOException {
        long purchasePrice = purchaseLottos();
        Lottos lottos = createPurchaseLottos(purchasePrice);
        WinningLotto winningLotto = createWinningLotto();

        lottos.compareLottos(winningLotto);
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

    private Lottos createPurchaseLottos(long purchasePrice) {
        Lottos lottos = new Lottos(purchasePrice);
        resultView.printPurchaseLottos(lottos);

        return lottos;
    }

    private WinningLotto createWinningLotto() throws IOException {
        List<Integer> winningLottoNumbers = inputView.inputWinningLottoNumbers();
        int bonusBall = inputView.inputBonusBall();

        return new WinningLotto(winningLottoNumbers, bonusBall);
    }
}
