package lotto.controller;

import static lotto.domain.Money.LOTTO_TICKET_PRICE;

import java.util.Collections;
import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
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
                    winningResults.winingRankCount(prizedRank));
            return;
        }
        OutputView.printTotalWinningCount(
                prizedRank.getCountOfMatch(),
                prizedRank.getWinningMoney(),
                winningResults.winingRankCount(prizedRank));
    }

    private LottoWinningResults getResultWithWinningLotto(PurchasedLottoTickets lottoTickets) {
        WinningLotto winningLotto = inputLottoNumbersAndBonusNumber();
        return lottoTickets.checkWinningLotto(winningLotto);
    }

    private WinningLotto inputLottoNumbersAndBonusNumber() {
        List<Integer> winningLottoNumbers = InputView.inputWinningLottoNumbers();
        int bonusBallNumber = InputView.inputBonusBallNumber();
        return WinningLotto.of(
                LottoNumbers.from(winningLottoNumbers),
                LottoNumber.from(bonusBallNumber)
        );
    }

    private PurchasedLottoTickets buyLottoTickets() {
        Money inputMoney = InputView.inputMoney();
        return vendingMachine.purchase(inputMoney);
    }
}
