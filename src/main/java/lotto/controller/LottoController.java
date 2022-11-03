package lotto.controller;

import lotto.model.dto.LottoResult;
import lotto.model.dto.PurchaseAmount;
import lotto.model.dto.WinLotto;
import lotto.model.vo.Lottos;
import lotto.model.vo.PurchaseCount;
import lotto.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    LottoServiceImpl lottoService = new LottoServiceImpl();

    public void play() {
        // 구입금액 입력 iv_1
        PurchaseAmount purchaseAmount = inputView.purchaseAmountInput();

        // 구입 개수 계산
        PurchaseCount purchaseCount = lottoService.getPurchaseCount(purchaseAmount);

        // 구입 개수 출력 ov_1
        resultView.printPurchaseCount(purchaseCount);

        // 로또 발급 (자동구입 개수 만큼)
        Lottos lottos = lottoService.generateAutoLotto(purchaseCount);

        // 로또 발급 번호 출력 ov_2
        resultView.printLotto(lottos);

        // 지난 주 당첨 번호 입력 iv_2
        WinLotto winLotto = inputView.winLottoInput();

        // 로또 당첨 결과 확인
        // 1. 일치개수기준별 당첨로또 수 확인
        // 2. 당첨로또 금액 합 계산 >> 수익률 계산
        LottoResult lottoResult = lottoService.checkLottoResult(winLotto, lottos);

        // 당첨 통계 출력 ov_3
        resultView.printLottoResult(lottoResult);
    }
}
