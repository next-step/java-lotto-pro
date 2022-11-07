package lotto.controller;

import lotto.model.dto.LottoResult;
import lotto.model.dto.PurchaseAmount;
import lotto.model.domain.Lottos;
import lotto.model.domain.Profit;
import lotto.model.domain.PurchaseInfo;
import lotto.model.domain.WinLotto;
import lotto.model.domain.WinResult;
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
        PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseAmount.getPurchaseAmount());
        resultView.printPurchaseCount(purchaseInfo);
        Lottos lottos = generateLotto(purchaseInfo);

        WinLotto winLotto = inputView.winLottoInput();

        LottoResult lottoResult = getLottoStatistics(purchaseAmount, lottos, winLotto);
        resultView.printLottoResult(lottoResult);
    }

    /**
     * 로또 발급
     *
     * @param purchaseInfo 구입정보 (금액, 개수)
     * @return 발급된 로또(전체)
     */
    private Lottos generateLotto(PurchaseInfo purchaseInfo) {
        Lottos lottos = lottoService.generateAutoLotto(purchaseInfo);
        resultView.printLotto(lottos);
        return lottos;
    }

    /**
     * 당첨 통계 확인
     * <p>
     * 당첨 결과, 수익률 확인
     *
     * @param purchaseAmount 구입금액
     * @param lottos         발급된 로또(전체)
     * @param winLotto       당첨 로또
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
