package step3;

import step3.configuration.AppConfig;
import step3.domain.LottoSeller;
import step3.domain.Lottos;
import step3.domain.PurchaseAmount;
import step3.domain.WinningLotto;
import step3.ui.InputView;
import step3.ui.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        InputView inputView = AppConfig.inputView();
        ResultView resultView = AppConfig.resultView();

        PurchaseAmount purchaseAmount = getPurchaseAmount(inputView, resultView);
        Lottos lottos = getLottos(resultView, purchaseAmount);
        printResult(inputView, resultView, purchaseAmount, lottos);
    }

    private static void printResult(InputView inputView, ResultView resultView, PurchaseAmount purchaseAmount, Lottos lottos) {
        WinningLotto winningLotto = inputView.readWinningLottoNumbers();
        resultView.printWinningResult(winningLotto, lottos, purchaseAmount);
    }

    private static Lottos getLottos(ResultView resultView, PurchaseAmount purchaseAmount) {
        Lottos lottos = LottoSeller.sellLottos(purchaseAmount);
        resultView.printLottos(lottos);
        return lottos;
    }

    private static PurchaseAmount getPurchaseAmount(InputView inputView, ResultView resultView) {
        PurchaseAmount purchaseAmount = inputView.readPurchaseAmount();
        resultView.printLottoTickets(purchaseAmount);
        return purchaseAmount;
    }
}
