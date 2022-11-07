package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

import java.util.List;

public interface InputView {
    PurchaseAmount readPurchaseAmount();

    WinningLotto readWinningLottoNumbers();

    int readManualLottoTicketCount(int allLottoTicketCount);

    List<Lotto> readManualLottos(int manualLottoTicketCount);
}
