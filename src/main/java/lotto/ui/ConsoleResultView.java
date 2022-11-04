package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

import java.util.List;

public class ConsoleResultView implements ResultView {

    private static final String MESSAGE_FOR_PRINT_LOTTO_TICKETS = "개를 구매했습니다.";
    private static final String MESSAGE_FOR_PRINT_TOTAL_YIELD = "총 수익률은 %.2f입니다.";

    @Override
    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    @Override
    public void printLottoTickets(PurchaseAmount purchaseAmount) {
        System.out.println(purchaseAmount.getLottoTicketCount() + MESSAGE_FOR_PRINT_LOTTO_TICKETS);
    }

    @Override
    public void printWinningResult(WinningResultDTO winningResultDTO) {
        System.out.println(winningResultDTO.ranks());
        System.out.printf(MESSAGE_FOR_PRINT_TOTAL_YIELD, winningResultDTO.yield());
    }
}
