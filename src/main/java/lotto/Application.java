package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {

        Payment payment = Payment.from(InputView.inputAmount());

        ManualLottoPurchase manualLottoPurchase = ManualLottoPurchase.from(InputView.inputManualPurchaseLotto());
        ManualLottoPurchaseMachine manualLottoPurchaseMachine = manualLottoPurchase.from(payment, InputView.inputManualLottoNumbers());

        int manualPurchaseCount = manualLottoPurchase.getPurchase();
        Lottos lottos = Lottos.buy(payment.getAutoPurchaseCount(manualPurchaseCount));
        ResultView.printPurchaseLotto(payment.getAutoPurchaseCount(manualPurchaseCount), manualPurchaseCount);
        lottos.addManualLottoNumbers(manualLottoPurchaseMachine);
        ResultView.printLottos(lottos);

        List<Integer> winningLottoNumber = InputView.inputWinningNumbers();
        WinningLotto winningLotto = WinningLotto.from(winningLottoNumber, InputView.inputWinningBonusNumbers());

        WinningStatistics winningStatistics = WinningStatistics.statistics(winningLotto, lottos);
        ResultView.printStatistics(winningStatistics);
        ResultView.printEarningsRate(winningStatistics);
    }
}
