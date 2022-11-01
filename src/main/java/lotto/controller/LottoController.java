package lotto.controller;

import lotto.controller.acceptor.MoneyToBuyAcceptor;
import lotto.controller.acceptor.WinningNumbersAcceptor;
import lotto.model.lotto.ticket.LottoNumberGenerator;
import lotto.model.lotto.ticket.LottoTicket;
import lotto.model.lotto.ticket.LottoTicketsBucket;
import lotto.model.money.to.buy.MoneyToBuy;
import lotto.model.winning.numbers.WinningNumbers;
import lotto.view.*;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoController(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void run() {
        final MoneyToBuy moneyToBuy = userInputMoneyToBuy();
        int numberOfAffordableLotto = moneyToBuy.affordableTicketCount();
        final LottoTicketsBucket lottoTicketsBucket = new LottoTicketsBucket(numberOfAffordableLotto);
        while (moneyToBuy.canBuyMoreLotto()) {
            moneyToBuy.buyOneLotto();
            numberOfAffordableLottoLeft(lottoTicketsBucket);
        }
        final WinningNumbers winningNumbers = userInputWinningNumbers();
//        displayLottoResult(winningNumbers, lottoTicketsBucket, moneyToBuy);
    }

    private MoneyToBuy userInputMoneyToBuy() {
        final MoneyToBuy moneyToBuy = new MoneyToBuyAcceptor().accept();
        NumberOfLottoTicketsPrinters.print(moneyToBuy);
        return moneyToBuy;
    }

    private void numberOfAffordableLottoLeft(LottoTicketsBucket lottoTicketsBucket) {
        final LottoTicket lottoTicket = new LottoTicket(lottoNumberGenerator);
        LottoTicketPrinter.print(lottoTicket);
        lottoTicketsBucket.addLottoTicket(lottoTicket);
    }

    private List<Integer> intsFromOneToFortyFive() {
        final List<Integer> fullCandidateList = new ArrayList<>(LOTTO_MAXIMUM_NUMBER);
        for (int i = LOTTO_MINIMUM_NUMBER; i <= LOTTO_MAXIMUM_NUMBER; ++i) {
            fullCandidateList.add(i);
        }
        return fullCandidateList;
    }

    private WinningNumbers userInputWinningNumbers() {
        BlankLinePrinter.print();
        return new WinningNumbersAcceptor().accept();
    }

    private void displayLottoResult(WinningNumbers winningNumbers, LottoTicketsBucket lottoTicketsBucket,
                                    MoneyToBuy moneyToBuy) {
        BlankLinePrinter.print();
        LottoScoreTitlePrinter.print();
//        lottoTicketsBucket.sameNumberCountOfAllLottoTickets(winningNumbers);
        LottoWinningStatisticsPrinter.print(lottoTicketsBucket);
//        final String profitRatioString = moneyToBuy.profitRatio(lottoTicketsBucket);
//        ProfitRatioPrinter.print(profitRatioString);
    }
}
