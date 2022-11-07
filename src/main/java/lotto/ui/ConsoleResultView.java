package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public class ConsoleResultView implements ResultView {

    private static final String MESSAGE_FOR_PRINT_LOTTO_TICKETS = "수동으로 %d장, 자동으로 %d개를 구매했습니다.%n";
    private static final String MESSAGE_FOR_PRINT_TOTAL_YIELD = "총 수익률은 %.2f입니다.";

    @Override
    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    @Override
    public void printLottoTickets(int manualLottoTicketCount, int autoLottoTicketCount) {
        System.out.printf(MESSAGE_FOR_PRINT_LOTTO_TICKETS, manualLottoTicketCount, autoLottoTicketCount);
    }

    @Override
    public void printWinningResult(WinningResultDTO winningResultDTO) {
        System.out.println(winningResultDTO.ranks());
        System.out.printf(MESSAGE_FOR_PRINT_TOTAL_YIELD, winningResultDTO.yield());
    }
}
