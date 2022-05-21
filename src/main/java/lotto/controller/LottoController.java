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
        int autoLottoCount = LottoPrice.numberOfLottoCanBuy(purchaseAmount);

        LottoManager lottoManager = new LottoManager(autoLottoCount);
        Lottos lottos = lottoManager.makeLottos(autoLottoCount);
        List<Lotto> lottoElements = lottos.getElements();

        ResultView.purchaseLottoResult(autoLottoCount, lottoElements);

        WinningLotto winningLotto = InputView.enterWinningLotto();
        lottoManager.makeWinningLotto(winningLotto, lottos);

        ResultView.winningResult(lottoManager.getWinningStatistics());
        ResultView.yieldResult(lottoManager.calculateRateOfReturn(purchaseAmount));
    }
}
