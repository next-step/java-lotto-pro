package lotto.controller;

import lotto.controller.acceptor.MoneyToBuyAcceptor;
import lotto.controller.acceptor.WinningNumbersAcceptor;
import lotto.controller.displayer.LottoResultStatisticsDisplayer;
import lotto.model.lotto.result.LottoResult;
import lotto.model.lotto.ticket.LottoNumberGenerator;
import lotto.model.lotto.ticket.LottoTicket;
import lotto.model.lotto.ticket.LottoTicketsBucket;
import lotto.model.money.to.buy.MoneyToBuy;
import lotto.model.winning.numbers.WinningNumbers;
import lotto.view.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        displayLottoResult(lottoTicketsBucket, winningNumbers, moneyToBuy);
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

    private void displayLottoResult(LottoTicketsBucket lottoTicketsBucket, WinningNumbers winningNumbers,
                                    MoneyToBuy moneyToBuy) {
        final LottoResult lottoResult = displayLottoStatistics(lottoTicketsBucket, winningNumbers);
        displayProfitRatio(lottoResult, moneyToBuy);
    }

    private LottoResult displayLottoStatistics(LottoTicketsBucket lottoTicketsBucket, WinningNumbers winningNumbers) {
        final int[][] prizes = new int[][]{{3, 5000}, {4, 50000}, {5, 150000}, {6, 2000000000}};
        final Map<Integer, Integer> prizeMoney = new HashMap<>();
        for (int[] prize : prizes) {
            prizeMoney.put(prize[0], prize[1]);
        }
        final Map<Integer, Integer> countsOfNumbersMatch = lottoTicketsBucket.calculateNumbersMatchCount(prizeMoney,
                winningNumbers);
        final LottoResult lottoResult = new LottoResult(prizeMoney, countsOfNumbersMatch);
        new LottoResultStatisticsDisplayer(prizeMoney, lottoResult).show();
        return lottoResult;
    }

    private void displayProfitRatio(LottoResult lottoResult, MoneyToBuy moneyToBuy) {
        final double profitRatio = lottoResult.profitRatio(moneyToBuy);
        ProfitRatioPrinter.print(profitRatio);
    }
}
