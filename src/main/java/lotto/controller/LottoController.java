package lotto.controller;

import java.util.List;
import lotto.WinningLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void startLotto() {
        LottoManager lottoManager = new LottoManager();

        int purchaseAmount = InputView.enterPurchaseAmount();
        Money money = new Money(purchaseAmount);
        int numberOfLottoCanBuy = lottoManager.numberOfLottoCanBuy(money);
        int manualLottoCount = InputView.enterManualLottoCount(numberOfLottoCanBuy);
        int autoLottoCount = numberOfLottoCanBuy - manualLottoCount;

        int[][] manualLottos = InputView.enterManualLottos(manualLottoCount);

        Lottos lottos = lottoManager.makeLottos(autoLottoCount, manualLottos);
        List<Lotto> lottoElements = lottos.getElements();

        ResultView.purchaseLottoResult(manualLottoCount, autoLottoCount, lottoElements);

        WinningLotto winningLotto = InputView.enterWinningLotto();
        lottoManager.makeWinningLotto(winningLotto, lottos);

        ResultView.winningResult(lottoManager.getWinningStatistics());
        ResultView.yieldResult(lottoManager.calculateRateOfReturn(purchaseAmount));
    }
}