package nextstep.lotto.service;

import nextstep.lotto.domain.PurchaseLottoAmount;
import nextstep.lotto.io.LottoDisplay;

public class LottoService {

    public void startLotto() {

        PurchaseLottoAmount purchaseLottoAmount = LottoDisplay.inputPurchaseAmount();
    }
}
