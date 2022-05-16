package lotto.controller;

import lotto.model.*;
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
        int nonAutoPurchaseCount = nonAutoPurchaseCount();

        Lottos lottos = createPurchaseLottos(purchasePrice, nonAutoPurchaseCount);
        WinningLotto winningLotto = createWinningLotto();

        WinningStatus winningStatus = lottos.compareLottos(winningLotto);
        winningStatistics(purchasePrice, winningStatus);
    }

    private long purchaseLottos() throws IOException {
        return inputView.inputPurchasePrice();
    }

    private int nonAutoPurchaseCount() throws IOException {
        return inputView.inputNonAutoPurchaseCount();
    }

    private Lottos createPurchaseLottos(PurchasePrice purchasePrice, int nonAutoPurchaseCount) throws IOException {
        Lottos lottos = new Lottos();
        inputView.inputNonAutoLottosTitle();
        for (int i = 0; i < nonAutoPurchaseCount; i++) {
            lottos.addLotto(new Lotto(inputView.inputNonAutoLottoNumbers()));
        }
        lottos.addLottos(new Lottos(purchasePrice, nonAutoPurchaseCount));
        resultView.printPurchaseLottos(nonAutoPurchaseCount, lottos);

        return lottos;
    }

    private WinningLotto createWinningLotto() throws IOException {
        List<Integer> winningLottoNumbers = inputView.inputWinningLottoNumbers();
        int bonusBall = inputView.inputBonusBall();

        return new WinningLotto(winningLottoNumbers, bonusBall);
    }

    private void winningStatistics(PurchasePrice purchasePrice, WinningStatus winningStatus) {
        resultView.printWinningStatisticsTitle();
        resultView.printWinningStatistics(winningStatus);
        resultView.printTotalEarningsRate(winningStatus, purchasePrice);
    }
}
