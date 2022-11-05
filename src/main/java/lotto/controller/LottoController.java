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
        final LottoTicketsBucket lottoTicketsBucket = new LottoTicketsBucket(moneyToBuy);
        while (lottoTicketsBucket.canBuyMoreLotto()) {
            final LottoTicket newLottoTicket = buyOneLottoTicket(lottoTicketsBucket);
            displayEachLottoTicket(newLottoTicket);
        }
        final WinningNumbers winningNumbers = userInputWinningNumbers();
        displayLottoResult(lottoTicketsBucket, winningNumbers, moneyToBuy);
    }

    private MoneyToBuy userInputMoneyToBuy() {
        final MoneyToBuy moneyToBuy = moneyToBuyAcceptor.accept();
        NumberOfLottoTicketsPrinters.print(moneyToBuy);
        return moneyToBuy;
    }

    private LottoTicket buyOneLottoTicket(LottoTicketsBucket lottoTicketsBucket) {
        final LottoTicket newLottoTicket = new LottoTicket(lottoNumberGenerator);
        lottoTicketsBucket.buyOneLotto(newLottoTicket);
        return newLottoTicket;
    }

    private void displayEachLottoTicket(LottoTicket lottoTicket) {
        LottoTicketPrinter.print(lottoTicket);
    }

    private WinningNumbers userInputWinningNumbers() {
        return winningNumbersAcceptor.accept();
    }

    private void displayLottoResult(LottoTicketsBucket lottoTicketsBucket, WinningNumbers winningNumbers,
                                    MoneyToBuy moneyToBuy) {
        final LottoResult lottoResult = calculateLottoStatistics(lottoTicketsBucket, winningNumbers);
        displayLottoResultStatistics(lottoResult);
        final double profitRatio = calculateProfitRatio(lottoResult, moneyToBuy);
        displayProfitRatio(profitRatio);
    }

    private LottoResult calculateLottoStatistics(LottoTicketsBucket lottoTicketsBucket, WinningNumbers winningNumbers) {
        final Map<LottoNumberMatchCount, Integer> countsOfNumbersMatch =
                lottoTicketsBucket.calculateNumbersMatchCount(prizeMoney, winningNumbers);
        return new LottoResult(prizeMoney, countsOfNumbersMatch);
    }

    private void displayLottoResultStatistics(LottoResult lottoResult) {
        new LottoResultStatisticsDisplayer(prizeMoney, lottoResult).show();
    }

    private double calculateProfitRatio(LottoResult lottoResult, MoneyToBuy moneyToBuy) {
        return lottoResult.profitRatio(moneyToBuy);
    }

    private void displayProfitRatio(double profitRatio) {
        ProfitRatioPrinter.print(profitRatio);
    }
}
