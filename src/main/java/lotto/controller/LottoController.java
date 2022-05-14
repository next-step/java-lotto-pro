package lotto.controller;

import static lotto.constants.LottoConstants.LOTTO_TICKET_PRICE;

import java.util.Collections;
import java.util.List;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTickets;
import lotto.domain.LottoVendingMachine;
import lotto.domain.LottoWinningResults;
import lotto.domain.Money;
import lotto.enums.LottoRank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoVendingMachine vendingMachine;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.vendingMachine = new LottoVendingMachine();
    }

    public void run() {
        LottoTickets lottoTickets = buyLottoTickets();

        int purchasedTicketsCount = lottoTickets.purchasedTicketsCount();

        reportingLottoTicketsInformation(lottoTickets, purchasedTicketsCount);

        LottoWinningResults winningResults = checkWinningLotto(lottoTickets);

        reportingLottoResult(purchasedTicketsCount, winningResults);

    }

    private void reportingLottoTicketsInformation(LottoTickets lottoTickets, int purchasedTicketsCount) {
        outputView.printPurchasedTicketsCount(purchasedTicketsCount);
        outputView.printTicketsNumbers(lottoTickets.toString());
    }

    private void reportingLottoResult(int purchasedTicketsCount, LottoWinningResults winningResults) {
        List<LottoRank> prizedRanks = LottoRank.getPrizedRanks();

        Collections.sort(prizedRanks,Collections.reverseOrder());

        for (LottoRank prizedRank : prizedRanks) {
            printWinningStatistics(winningResults, prizedRank);
        }

        int usedMoney = purchasedTicketsCount * LOTTO_TICKET_PRICE;
        outputView.printTotalProfitRate(winningResults.profitRate(Money.from(usedMoney)));
    }

    private void printWinningStatistics(LottoWinningResults winningResults, LottoRank prizedRank) {
        outputView.printTotalWinningCount(
                prizedRank.getCountOfMatch(),
                prizedRank.getWinningMoney(),
                winningResults.winingRankCount(prizedRank));
    }

    private LottoWinningResults checkWinningLotto(LottoTickets lottoTickets) {
        List<Integer> winningLottoNumbers = inputView.inputWinningLottoNumbers();
        return lottoTickets.match(LottoNumbers.from(() -> winningLottoNumbers));
    }

    private LottoTickets buyLottoTickets() {
        Money inputMoney = inputView.inputMoney();
        return vendingMachine.purchase(inputMoney);
    }
}
