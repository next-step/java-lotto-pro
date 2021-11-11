package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        Payment payment = new Payment(InputView.inputAmount());
        ResultView.printPurchaseConfirmation(payment);

        Lottos lottos = Lottos.buy(payment.getPurchaseCount());
        ResultView.printLottos(lottos);
        List<Integer> winningLottoNumber = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputWinningBonusNumbers();
        WinningLotto winningLotto = WinningLotto.from(winningLottoNumber, bonusNumber);

        WinningStatistics winningStatistics = WinningStatistics.statistics(winningLotto, lottos);
        ResultView.printStatistics(winningStatistics);
        ResultView.printEarningsRate(winningStatistics);
    }
}
