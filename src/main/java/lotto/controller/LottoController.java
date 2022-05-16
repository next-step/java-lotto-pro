package lotto.controller;

import static lotto.domain.Money.LOTTO_TICKET_PRICE;

import java.util.Collections;
import java.util.List;
import lotto.controller.converter.MoneyConverter;
import lotto.controller.converter.WinningLottoConverter;
import lotto.controller.dto.MoneyDTO;
import lotto.controller.dto.WinningLottoDTO;
import lotto.domain.PurchasedLottoTickets;
import lotto.domain.LottoVendingMachine;
import lotto.domain.LottoWinningResults;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.enums.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoVendingMachine vendingMachine;

    public LottoController() {
        this.vendingMachine = new LottoVendingMachine();
    }

    public void run() {
        PurchasedLottoTickets lottoTickets = buyLottoTickets();

        int purchasedTicketsCount = lottoTickets.purchasedTicketsCount();

        reportingLottoTicketsInformation(lottoTickets, purchasedTicketsCount);

        LottoWinningResults winningResults = getResultWithWinningLotto(lottoTickets);

        reportingLottoResult(purchasedTicketsCount, winningResults);

    }

    private void reportingLottoTicketsInformation(PurchasedLottoTickets lottoTickets, int purchasedTicketsCount) {
        OutputView.printPurchasedTicketsCount(purchasedTicketsCount);
        OutputView.printTicketsNumbers(lottoTickets.toString());
    }

    private void reportingLottoResult(int purchasedTicketsCount, LottoWinningResults winningResults) {
        List<LottoRank> prizedRanks = LottoRank.getPrizedRanks();

        prizedRanks.sort(Collections.reverseOrder());

        OutputView.printTotalString();
        for (LottoRank prizedRank : prizedRanks) {
            printWinningStatistics(winningResults, prizedRank);
        }

        int usedMoney = purchasedTicketsCount * LOTTO_TICKET_PRICE;
        OutputView.printTotalProfitRate(winningResults.profitRate(Money.from(usedMoney)));
    }

    private void printWinningStatistics(LottoWinningResults winningResults, LottoRank prizedRank) {
        if (prizedRank.equals(LottoRank.SECOND)) {
            OutputView.printSecondWinningCount(
                    prizedRank.getCountOfMatch(),
                    prizedRank.getWinningMoney(),
                    winningResults.winningRankCount(prizedRank));
            return;
        }
        OutputView.printTotalWinningCount(
                prizedRank.getCountOfMatch(),
                prizedRank.getWinningMoney(),
                winningResults.winningRankCount(prizedRank));
    }

    private LottoWinningResults getResultWithWinningLotto(PurchasedLottoTickets lottoTickets) {
        WinningLottoDTO winningLottoDTO = InputView.inputLottoInformation();
        WinningLotto winningLotto = WinningLottoConverter.convert(winningLottoDTO);
        return lottoTickets.checkWinningLotto(winningLotto);
    }

    private PurchasedLottoTickets buyLottoTickets() {
        MoneyDTO moneyDTO = InputView.inputMoney();
        Money inputMoney = MoneyConverter.convert(moneyDTO);
        return vendingMachine.purchase(inputMoney);
    }
}
