package step3.ui;

import step3.domain.Lottos;
import step3.domain.PurchaseAmount;
import step3.domain.WinningLotto;

public class ConsoleResultView implements ResultView {

    public static final String MESSAGE_FOR_PRINT_LOTTO_TICKETS = "개를 구매했습니다.";

    @Override
    public void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    @Override
    public void printLottoTickets(PurchaseAmount purchaseAmount) {
        System.out.println(purchaseAmount.getLottoTicketCount() + MESSAGE_FOR_PRINT_LOTTO_TICKETS);
    }

    @Override
    public void printWinningResult(WinningLotto winningLotto, Lottos lottos) {

    }
}
