package lotto.controller;

import lotto.controller.acceptor.MoneyToBuyAcceptor;
import lotto.controller.acceptor.WinningNumbersAcceptor;
import lotto.controller.displayer.LottoResultStatisticsDisplayer;
import lotto.model.lotto.enums.LottoNumberMatchCount;
import lotto.model.lotto.result.LottoResult;
import lotto.model.lotto.ticket.LottoNumberGenerator;
import lotto.model.lotto.ticket.LottoTicket;
import lotto.model.lotto.ticket.LottoTicketsBucket;
import lotto.model.money.to.buy.MoneyToBuy;
import lotto.model.winning.numbers.WinningNumbers;
import lotto.view.*;

import java.util.Map;

public class LottoController {
    private static final int LOTTO_MINIMUM_NUMBER = 1;
    private static final int LOTTO_MAXIMUM_NUMBER = 45;
    private final Map<LottoNumberMatchCount, Integer> prizeMoney;
    private final MoneyToBuyAcceptor moneyToBuyAcceptor;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final WinningNumbersAcceptor winningNumbersAcceptor;

    public LottoController(Map<LottoNumberMatchCount, Integer> prizeMoney, MoneyToBuyAcceptor moneyToBuyAcceptor,
                           LottoNumberGenerator lottoNumberGenerator, WinningNumbersAcceptor winningNumbersAcceptor) {
        this.prizeMoney = prizeMoney;
        this.moneyToBuyAcceptor = moneyToBuyAcceptor;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.winningNumbersAcceptor = winningNumbersAcceptor;
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
        final MoneyToBuy moneyToBuy = moneyToBuyAcceptor.accept();
        NumberOfLottoTicketsPrinters.print(moneyToBuy);
        return moneyToBuy;
    }

    private void numberOfAffordableLottoLeft(LottoTicketsBucket lottoTicketsBucket) {
        final LottoTicket lottoTicket = new LottoTicket(lottoNumberGenerator);
        LottoTicketPrinter.print(lottoTicket);
        lottoTicketsBucket.addLottoTicket(lottoTicket);
    }

    private WinningNumbers userInputWinningNumbers() {
        return winningNumbersAcceptor.accept();
    }

    private void displayLottoResult(LottoTicketsBucket lottoTicketsBucket, WinningNumbers winningNumbers,
                                    MoneyToBuy moneyToBuy) {
        final LottoResult lottoResult = displayLottoStatistics(lottoTicketsBucket, winningNumbers);
        displayProfitRatio(lottoResult, moneyToBuy);
    }

    private LottoResult displayLottoStatistics(LottoTicketsBucket lottoTicketsBucket, WinningNumbers winningNumbers) {
        final Map<LottoNumberMatchCount, Integer> countsOfNumbersMatch =
                lottoTicketsBucket.calculateNumbersMatchCount(prizeMoney, winningNumbers);
        final LottoResult lottoResult = new LottoResult(prizeMoney, countsOfNumbersMatch);
        new LottoResultStatisticsDisplayer(prizeMoney, lottoResult).show();
        return lottoResult;
    }

    private void displayProfitRatio(LottoResult lottoResult, MoneyToBuy moneyToBuy) {
        final double profitRatio = lottoResult.profitRatio(moneyToBuy);
        ProfitRatioPrinter.print(profitRatio);
    }
}
