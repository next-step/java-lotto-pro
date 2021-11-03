package lotto;

import lotto.domain.*;
import lotto.domain.startegy.generationstrategy.AutoNumberGenerationStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApp {

    public static void main(String[] args) {
        Payment payment = Payment.from(InputView.inputAmount());
        Lottos lottos = LottoMachine.buy(payment, new AutoNumberGenerationStrategy());

        ResultView.printLottoCount(lottos);
        ResultView.printLottos(lottos);

        Lotto winningLotto = Lotto.from(InputView.inputWinningNumbers());

        WinningsStatistics winningsStatistics = WinningsStatistics.statistics(winningLotto, lottos);
        ResultView.printStatistics(winningsStatistics);
        ResultView.printEarningsRate(winningsStatistics);
    }

}
