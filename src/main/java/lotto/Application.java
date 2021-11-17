package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {

        Payment payment = Payment.from(InputView.inputAmount(), InputView.inputManualPurchaseLotto());

        ManualLottoPurchaseMachine manualLottoPurchaseMachine = payment.from(InputView.inputManualLottoNumbers());

        Lottos lottos = Lottos.buy(payment.getAutoPurchaseCount());
        ResultView.printPurchaseLotto(payment.getAutoPurchaseCount(), payment.getManualLottoPurchase());
        lottos.addManualLottoNumbers(manualLottoPurchaseMachine);
        ResultView.printLottos(lottos);

        List<Integer> winningLottoNumber = InputView.inputWinningNumbers();
        WinningLotto winningLotto = WinningLotto.from(winningLottoNumber, InputView.inputWinningBonusNumbers());

        WinningStatistics winningStatistics = WinningStatistics.statistics(winningLotto, lottos);
        ResultView.printStatistics(winningStatistics);
        ResultView.printEarningsRate(winningStatistics);
    }
}
