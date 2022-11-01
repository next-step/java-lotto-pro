package step3.ui;

import step3.domain.PurchaseAmount;
import step3.domain.WinningLotto;

public interface InputView {

    PurchaseAmount readPurchaseAmount();

    WinningLotto readWinningLottoNumbers();
}
