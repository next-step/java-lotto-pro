package step3.ui;

import step3.domain.*;

import java.util.List;
import java.util.Map;

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
    public void printWinningResult(WinningLotto winningLotto, Lottos lottos, PurchaseAmount purchaseAmount) {
        WinningResult result = new WinningResult();
        for (Lotto lotto : lottos.lottos()) {
            result.addRank(winningLotto.rank(lotto));
        }
        System.out.print(result);
        System.out.printf(MESSAGE_FOR_PRINT_TOTAL_YIELD, result.getYield(purchaseAmount));
    }
}
