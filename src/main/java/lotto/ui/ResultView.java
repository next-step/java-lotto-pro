package lotto.ui;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public interface ResultView {
    void printLottos(Lottos lottos);

    void printAllLottoTicketCount(int manualLottoTicketCount, int autoLottoTicketCount);

    void printWinningResult(WinningLotto winningLotto, Lottos lottos);
}
