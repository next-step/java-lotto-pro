package lotto;

import lotto.configuration.AppConfig;
import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.ui.WinningResultDTO;

import java.util.List;
import java.util.Map;

public class LottoApplication {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        InputView inputView = AppConfig.inputView();
        ResultView resultView = AppConfig.resultView();

        PurchaseAmount purchaseAmount = getPurchaseAmount(inputView);
        List<Lotto> manualLottos = getManualLottos(inputView, purchaseAmount);
        List<Lotto> lottos = getLottos(resultView, manualLottos, purchaseAmount);

        WinningResultDTO winningResultDTO = getWinningResultDTO(inputView, purchaseAmount, lottos);
        resultView.printWinningResult(winningResultDTO);
    }

    private static List<Lotto> getManualLottos(InputView inputView, PurchaseAmount purchaseAmount) {
        int manualLottoTicketCount = inputView.readManualLottoTicketCount(purchaseAmount.getLottoTicketCount());
        return inputView.readManualLottos(manualLottoTicketCount);
    }

    private static WinningResultDTO getWinningResultDTO(InputView inputView, PurchaseAmount purchaseAmount, List<Lotto> lottos) {
        WinningLotto winningLotto = inputView.readWinningLottoNumbers();
        WinningResult result = new WinningResult();
        Map<WinningLottoRank, Integer> ranks = result.reportRanks(winningLotto, lottos);
        double yield = result.reportYield(purchaseAmount);
        return new WinningResultDTO(ranks, yield);
    }

    private static List<Lotto> getLottos(ResultView resultView, List<Lotto> manualLottos, PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = LottoSeller.sellLottos(purchaseAmount, manualLottos);
        resultView.printLottoTickets(manualLottos.size(), lottos.size() - manualLottos.size());
        resultView.printLottos(lottos);
        return lottos;
    }

    private static PurchaseAmount getPurchaseAmount(InputView inputView) {
        return inputView.readPurchaseAmount();
    }
}
