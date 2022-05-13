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
        outputView.printPurchasedTicketsCount(purchasedTicketsCount);
        outputView.printTicketsNumbers(lottoTickets.purchasedTicketNumberString());

        LottoWinningResults winningResults = checkWinningLotto(lottoTickets);

        List<LottoRank> prizedRanks = LottoRank.getPrizedRanks();

        for (LottoRank prizedRank : prizedRanks) {
            printWinningStatistics(winningResults, prizedRank);
        }
        outputView.printTotalProfitRate(winningResults.profitRate(Money.from(purchasedTicketsCount * LOTTO_TICKET_PRICE)));

    }

    private void printWinningStatistics(LottoWinningResults winningResults, LottoRank prizedRank) {
        outputView.printTotalWinningCount(
                prizedRank.getCountOfMatch(),
                prizedRank.getWinningMoney(),
                winningResults.winingRankCount(prizedRank));
    }

    private LottoWinningResults checkWinningLotto(LottoTickets lottoTickets) {
        List<Integer> winningLottoNumbers = inputView.inputWinningLottoNumbers();
        LottoWinningResults winningResults = lottoTickets.match(LottoNumbers.from(() -> winningLottoNumbers));
        return winningResults;
    }

    private LottoTickets buyLottoTickets() {
        Money inputMoney = inputView.inputMoney();
        LottoTickets lottoTickets = vendingMachine.purchase(inputMoney);
        return lottoTickets;
    }
}
