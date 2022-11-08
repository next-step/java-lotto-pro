package lotto;

import lotto.configuration.AppConfig;
import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
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
        Lottos lottos = getAllLottos(manualLottos, autoLottoTicketCount);

        resultView.printAllLottoTicketCount(manualLottoTicketCount, autoLottoTicketCount);
        resultView.printLottos(lottos);

        WinningLotto winningLotto = inputView.readWinningLotto();
        resultView.printWinningResult(winningLotto, lottos);
    }

    private static Lottos getAllLottos(Lottos manualLottos, int autoLottoTicketCount) {
        Lottos autoLottos = LottoSeller.sellAutoLottos(autoLottoTicketCount);
        return LottoSeller.integrationLottos(manualLottos, autoLottos);
    }
}
