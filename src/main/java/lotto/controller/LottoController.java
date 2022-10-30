package lotto.controller;

import lotto.constant.numbers.LottoConstant;
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
    public void run() {
        final MoneyToBuy moneyToBuy = userInputMoneyToBuy();
        int numberOfAffordableLotto = moneyToBuy.numberOfAffordableLottoTickets();
        final LottoTicketsBucket lottoTicketsBucket = new LottoTicketsBucket(numberOfAffordableLotto);
        while (0 < numberOfAffordableLotto--) {
            numberOfAffordableLottoLeft(lottoTicketsBucket);
        }
        final WinningNumbers winningNumbers = userInputWinningNumbers();
        displayResultOfBoughtLotto(winningNumbers, lottoTicketsBucket, moneyToBuy);
    }

    private MoneyToBuy userInputMoneyToBuy() {
        DemandMoneyToBuyInputPrinter.print();
        final MoneyToBuy moneyToBuy = new MoneyToBuyAcceptor().accept();
        NumberOfLottoTicketsPrinters.print(moneyToBuy);
        return moneyToBuy;
    }

    private void numberOfAffordableLottoLeft(LottoTicketsBucket lottoTicketsBucket) {
        final List<Integer> candidates = intsFromOneToFortyFive();
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(candidates);
        final LottoTicket lottoTicket = new LottoTicket(lottoNumberGenerator);
        LottoTicketPrinter.print(lottoTicket);
        lottoTicketsBucket.addLottoTicket(lottoTicket);
    }

    private List<Integer> intsFromOneToFortyFive() {
        final List<Integer> fullCandidateList = new ArrayList<>(LottoConstant.LOTTO_MAXIMUM_NUMBER);
        for (int i = LottoConstant.LOTTO_MINIMUM_NUMBER; i <= LottoConstant.LOTTO_MAXIMUM_NUMBER; ++i) {
            fullCandidateList.add(i);
        }
        return fullCandidateList;
    }

    private WinningNumbers userInputWinningNumbers() {
        BlankLinePrinter.print();
        DemandWinningNumbersInputPrinter.print();
        return new WinningNumbersAcceptor().accept();
    }

    private void displayResultOfBoughtLotto(WinningNumbers winningNumbers, LottoTicketsBucket lottoTicketsBucket,
                                            MoneyToBuy moneyToBuy) {
        BlankLinePrinter.print();
        LottoScoreTitlePrinter.print();
        lottoTicketsBucket.sameNumberCountOfAllLottoTickets(winningNumbers);
        LottoWinningStatisticsPrinter.print(lottoTicketsBucket);
        final String profitRatioString = moneyToBuy.profitRatio(lottoTicketsBucket);
        ProfitRatioPrinter.print(profitRatioString);
    }
}
