package lotto;

import lotto.configuration.AppConfig;
import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = AppConfig.inputView();
        ResultView resultView = AppConfig.resultView();
        run(inputView, resultView);
    }

    private static void run(InputView inputView, ResultView resultView) {
        PurchaseAmount purchaseAmount = inputView.readPurchaseAmount();
        Lottos manualLottos = inputView.readManualLottos(purchaseAmount);

        int manualLottoTicketCount = manualLottos.lottos().size();
        int autoLottoTicketCount = purchaseAmount.getLottoTicketCount() - manualLottoTicketCount;
        resultView.printAllLottoTicketCount(manualLottoTicketCount, autoLottoTicketCount);

        Lottos lottos = getAllLottos(manualLottos, purchaseAmount);
        resultView.printLottos(lottos);

        WinningLotto winningLotto = inputView.readWinningLotto();
        resultView.printWinningResult(winningLotto, lottos);
    }

    private static Lottos getAllLottos(Lottos manualLottos, PurchaseAmount purchaseAmount) {
        Lottos autoLottos = LottoSeller.sellAutoLottos(purchaseAmount.getLottoTicketCount());
        return LottoSeller.integrationLottos(manualLottos, autoLottos);
    }
}
