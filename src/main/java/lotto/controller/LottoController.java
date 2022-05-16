package lotto.controller;

import lotto.model.Lottos;
import lotto.model.PurchasePrice;
import lotto.model.WinningLotto;
import lotto.model.WinningStatus;
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
        PurchasePrice purchasePrice = new PurchasePrice(purchaseLottos());
        Lottos lottos = createPurchaseLottos(purchasePrice);
        WinningLotto winningLotto = createWinningLotto();

        WinningStatus winningStatus = lottos.compareLottos(winningLotto);
        winningStatistics(purchasePrice, winningStatus);
    }

    private void winningStatistics(PurchasePrice purchasePrice, WinningStatus winningStatus) {
        resultView.printWinningStatisticsTitle();
        resultView.printWinningStatistics(winningStatus);
        resultView.printTotalEarningsRate(winningStatus, purchasePrice);
    }

    private long purchaseLottos() throws IOException {
        return inputView.inputPurchasePrice();
    }

    private Lottos createPurchaseLottos(PurchasePrice purchasePrice) {
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
