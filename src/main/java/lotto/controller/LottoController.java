package lotto.controller;

import lotto.model.domain.Lottos;
import lotto.model.domain.Profit;
import lotto.model.domain.PurchaseInfo;
import lotto.model.domain.WinLotto;
import lotto.model.domain.WinResult;
import lotto.model.dto.LottoResult;
import lotto.model.dto.PurchaseAmount;
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
        PurchaseInfo purchaseInfo = purchaseLotto();
        Lottos lottos = generateLotto(purchaseInfo);

        WinLotto winLotto = inputView.winLottoInput();

        LottoResult lottoResult = getLottoStatistics(purchaseInfo, lottos, winLotto);
        resultView.printLottoResult(lottoResult);
    }

    /**
     * 로또 구입
     *
     * @return 구입정보
     */
    private PurchaseInfo purchaseLotto() {
        PurchaseAmount purchaseAmount = inputView.purchaseAmountInput();
        PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseAmount.getPurchaseAmount());
        resultView.printPurchaseCount(purchaseInfo);
        return purchaseInfo;
    }

    /**
     * 로또 발급
     *
     * @param purchaseInfo 구입정보
     * @return 발급된 로또(전체)
     */
    private Lottos generateLotto(PurchaseInfo purchaseInfo) {
        Lottos lottos = lottoService.generateAutoLotto(purchaseInfo);
        resultView.printLottos(lottos);
        return lottos;
    }

    /**
     * 당첨 통계 확인
     * <p>
     * 당첨 결과, 수익률 확인
     *
     * @param purchaseInfo 구입정보
     * @param lottos       발급된 로또(전체)
     * @param winLotto     당첨 로또
     * @return 당첨 통계
     */
    private LottoResult getLottoStatistics(PurchaseInfo purchaseInfo, Lottos lottos, WinLotto winLotto) {
        WinResult winResult = lottoService.checkLottoResult(winLotto, lottos);
        Profit profit = lottoService.calculateProfit(purchaseInfo, winResult);

        return new LottoResult(winResult, profit);
    }
}
