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
            final LottoTicket newLottoTicket = new LottoTicket(lottoNumberGenerator);
            lottoTicketsBucket.buyOneLotto(newLottoTicket);
            LottoTicketPrinter.print(newLottoTicket);
        }
        final WinningNumbers winningNumbers = userInputWinningNumbers();
        displayLottoResult(lottoTicketsBucket, winningNumbers, moneyToBuy);
    }

    private MoneyToBuy userInputMoneyToBuy() {
        final MoneyToBuy moneyToBuy = moneyToBuyAcceptor.accept();
        NumberOfLottoTicketsPrinters.print(moneyToBuy);
        return moneyToBuy;
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
