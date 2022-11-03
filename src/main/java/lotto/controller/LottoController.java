package lotto.controller;

import lotto.model.dto.LottoResult;
import lotto.model.dto.PurchaseAmount;
import lotto.model.vo.WinLotto;
import lotto.model.vo.Lottos;
import lotto.model.vo.Profit;
import lotto.model.vo.PurchaseCount;
import lotto.model.vo.WinResult;
import lotto.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    LottoServiceImpl lottoService = new LottoServiceImpl();

    /**
     * 로또 구입 및 당첨확인 시작
     */
    public void play() {
        PurchaseAmount purchaseAmount = inputView.purchaseAmountInput();
        Lottos lottos = generateLotto(purchaseAmount);

        WinLotto winLotto = inputView.winLottoInput();

        LottoResult lottoResult = getLottoStatistics(purchaseAmount, lottos, winLotto);
        resultView.printLottoResult(lottoResult);
    }

    /**
     * 로또 발급
     *
     * @param purchaseAmount 구입금액
     * @return 발급된 로또(전체)
     */
    private Lottos generateLotto(PurchaseAmount purchaseAmount) {
        PurchaseCount purchaseCount = lottoService.getPurchaseCount(purchaseAmount);
        resultView.printPurchaseCount(purchaseCount);
        Lottos lottos = lottoService.generateAutoLotto(purchaseCount);
        resultView.printLotto(lottos);
        return lottos;
    }

    /**
     * 당첨 통계 확인
     *
     * 당첨 결과, 수익률 확인
     * @param purchaseAmount 구입금액
     * @param lottos 발급된 로또(전체)
     * @param winLotto 당첨 로또
     * @return 당첨 통계
     */
    private LottoResult getLottoStatistics(PurchaseAmount purchaseAmount, Lottos lottos, WinLotto winLotto) {
        WinResult winResult = lottoService.checkLottoResult(winLotto, lottos);
        Profit profit = lottoService.calculateProfit(purchaseAmount, winResult);

        LottoResult lottoResult = new LottoResult();
        lottoResult.setWinResult(winResult);
        lottoResult.setProfit(profit);
        return lottoResult;
    }
}
