package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public interface ResultView {
    void printLottos(List<Lotto> lottos);

    void printLottoTickets(int manualLottoTicketCount, int autoLottoTicketCount);

    void printWinningResult(WinningResultDTO winningResultDTO);
}
