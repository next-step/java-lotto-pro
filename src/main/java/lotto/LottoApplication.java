package lotto;

import lotto.configuration.AppConfig;
import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.ui.WinningResultDTO;

import java.util.Map;

public class LottoApplication {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        InputView inputView = AppConfig.inputView();
        ResultView resultView = AppConfig.resultView();

        PurchaseAmount purchaseAmount = getPurchaseAmount(inputView, resultView);
        Lottos lottos = getLottos(resultView, purchaseAmount);

        WinningResultDTO winningResultDTO = getWinningResultDTO(inputView, purchaseAmount, lottos);
        resultView.printWinningResult(winningResultDTO);
    }

    private static WinningResultDTO getWinningResultDTO(InputView inputView, PurchaseAmount purchaseAmount, Lottos lottos) {
        WinningLotto winningLotto = inputView.readWinningLottoNumbers();
        WinningResult result = new WinningResult();
        Map<WinningLottoRank, Integer> ranks = result.reportRanks(winningLotto, lottos);
        double yield = result.reportYield(purchaseAmount);
        return new WinningResultDTO(ranks, yield);
    }

    private static Lottos getLottos(ResultView resultView, PurchaseAmount purchaseAmount) {
        Lottos lottos = LottoSeller.sellLottos(purchaseAmount);
        resultView.printLottos(lottos.lottos());
        return lottos;
    }

    private static PurchaseAmount getPurchaseAmount(InputView inputView, ResultView resultView) {
        PurchaseAmount purchaseAmount = inputView.readPurchaseAmount();
        resultView.printLottoTickets(purchaseAmount);
        return purchaseAmount;
    }
}
