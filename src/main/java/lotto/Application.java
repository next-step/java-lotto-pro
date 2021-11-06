package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Payment;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {

    public static void main(String[] args) {

        Payment payment = new Payment(InputView.inputAmount());
        ResultView.printPurchaseConfirmation(payment);

        Lottos lottos = Lottos.buy(payment.getPurchaseCount());
        ResultView.printLottos(lottos);
        Lotto winningLotto = Lotto.from(InputView.inputWinningNumbers());

        WinningStatistics winningStatistics = WinningStatistics.statistics(winningLotto, lottos);
        ResultView.printStatistics(winningStatistics);
        ResultView.printEarningsRate(winningStatistics);
    }
}
