package nextstep.lotto.service;

import nextstep.lotto.domain.LottoCount;
import nextstep.lotto.domain.PurchaseLotto;
import nextstep.lotto.domain.PurchaseLottoAmount;
import nextstep.lotto.io.LottoDisplay;

public class LottoService {

    public void startLotto() {

        PurchaseLottoAmount purchaseLottoAmount = LottoDisplay.inputPurchaseAmount();
        LottoCount lottoCount = new LottoCount(purchaseLottoAmount);
        LottoDisplay.printLottoCountResult(lottoCount);

        PurchaseLotto purchaseLotto = lottoCount.purchaseLottoByLottoCount();
        LottoDisplay.printAutoLottoResult(purchaseLotto);

    }
}
