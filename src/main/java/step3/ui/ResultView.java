package step3.ui;

import step3.domain.Lotto;
import step3.domain.Lottos;
import step3.domain.PurchaseAmount;
import step3.domain.WinningLotto;

import java.util.List;

public interface ResultView {
    void printLottos(List<Lotto> lottos);

    void printLottoTickets(PurchaseAmount purchaseAmount);

    void printWinningResult(WinningLotto winningLotto, Lottos lottos, PurchaseAmount purchaseAmount);
}
