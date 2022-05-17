package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.LottoPrice;
import lotto.strategy.ManualPickNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void startLotto() {
        System.out.println("구입금액을 입력해주세요");
        int purchaseAmount = InputView.enterNumber();

        LottoManager lottoManager = new LottoManager(
            LottoPrice.numberOfLottoCanBuy(purchaseAmount));

        ResultView.purchaseResult(LottoPrice.numberOfLottoCanBuy(purchaseAmount));
        ResultView.lottoNumberResult(lottoManager.getLottoElements());

        lottoManager.makeWinningLotto(new Lotto(new ManualPickNumberStrategy()));
        ResultView.winningResult(lottoManager.getWinningStatistics());

        ResultView.yieldResult(lottoManager.calculateRateOfReturn(purchaseAmount));
    }
}
