package step3.ui;

import step3.domain.Lottos;
import step3.domain.PurchaseAmount;
import step3.domain.WinningLotto;

public interface ResultView {
    void printLottos(Lottos lottos);

    void printLottoTickets(PurchaseAmount purchaseAmount);

    void printWinningResult(WinningLotto winningLotto, Lottos lottos);
}
