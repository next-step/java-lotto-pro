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
        int manualLottoPurchaseCount = manualLottoPurchaseCount();
        purchasePrice.validatePurchasePrice(manualLottoPurchaseCount);

        Lottos lottos = createPurchaseLottos(purchasePrice, manualLottoPurchaseCount);
        WinningLotto winningLotto = createWinningLotto();

        WinningStatus winningStatus = lottos.compareLottos(winningLotto);
        winningStatistics(purchasePrice, winningStatus);
    }

    private long purchaseLottos() throws IOException {
        return inputView.inputPurchasePrice();
    }

    private int manualLottoPurchaseCount() throws IOException {
        return inputView.inputManualLottoPurchaseCount();
    }

    private Lottos createPurchaseLottos(PurchasePrice purchasePrice, int manualLottoPurchaseCount) throws IOException {
        Lottos lottos = new Lottos();
        inputView.inputManualLottosTitle();
        for (int i = 0; i < manualLottoPurchaseCount; i++) {
            lottos.addLotto(new Lotto(inputView.inputManualLottoNumbers()));
        }

        long autoPurchasePrice = purchasePrice.excludePrice((long) manualLottoPurchaseCount * Lotto.LOTTO_PRICE);
        lottos.addLottos(new Lottos(new PurchasePrice(autoPurchasePrice)));
        resultView.printPurchaseLottos(manualLottoPurchaseCount, lottos);

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
