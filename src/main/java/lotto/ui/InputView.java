package lotto.ui;

import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

public interface InputView {
    PurchaseAmount readPurchaseAmount();

    Lottos readManualLottos(PurchaseAmount purchaseAmount);

    WinningLotto readWinningLotto();
}
