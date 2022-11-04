package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

import java.util.List;

public interface ResultView {
    void printLottos(List<Lotto> lottos);

    void printLottoTickets(PurchaseAmount purchaseAmount);

    void printWinningResult(WinningResultDTO winningResultDTO);
}
