package lotto.ui;

import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

public interface InputView {

    PurchaseAmount readPurchaseAmount();

    WinningLotto readWinningLottoNumbers();
}
