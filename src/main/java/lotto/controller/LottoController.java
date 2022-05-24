package lotto.controller;

import java.util.List;
import lotto.WinningLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.LottoPrice;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void startLotto() {
        int purchaseAmount = InputView.enterPurchaseAmount();
        int numberOfLottoCanBuy = LottoPrice.numberOfLottoCanBuy(purchaseAmount);
        int manualLottoCount = InputView.enterManualLottoCount(numberOfLottoCanBuy);
        int autoLottoCount = LottoPrice.numberOfLottoCanBuy(purchaseAmount) - manualLottoCount;
        int[][] manualLottos = InputView.enterManualLottos(manualLottoCount);

        LottoManager lottoManager = new LottoManager();
        Lottos lottos = lottoManager.makeLottos(autoLottoCount, manualLottos);
        List<Lotto> lottoElements = lottos.getElements();

        ResultView.purchaseLottoResult(manualLottoCount, autoLottoCount, lottoElements);

        WinningLotto winningLotto = InputView.enterWinningLotto();
        lottoManager.makeWinningLotto(winningLotto, lottos);

        ResultView.winningResult(lottoManager.getWinningStatistics());
        ResultView.yieldResult(lottoManager.calculateRateOfReturn(purchaseAmount));
    }
}