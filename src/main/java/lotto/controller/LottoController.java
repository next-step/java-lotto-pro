package lotto.controller;

import lotto.controller.acceptor.BonusAcceptor;
import lotto.controller.acceptor.MoneyToBuyAcceptor;
import lotto.controller.acceptor.WinningNumbersAcceptor;
import lotto.controller.displayer.LottoResultStatisticsDisplayer;
import lotto.model.lotto.enums.LottoNumberMatchCount;
import lotto.model.lotto.result.LottoResult;
import lotto.model.lotto.ticket.LottoNumber;
import lotto.model.lotto.ticket.LottoNumberGenerator;
import lotto.model.lotto.ticket.LottoTicket;
import lotto.model.lotto.ticket.LottoTicketsBucket;
import lotto.model.money.to.buy.MoneyToBuy;
import lotto.model.winning.numbers.WinningNumbers;
import lotto.view.*;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final Map<LottoNumberMatchCount, Integer> prizeMoney;
    private final MoneyToBuyAcceptor moneyToBuyAcceptor;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final WinningNumbersAcceptor winningNumbersAcceptor;
    private final BonusAcceptor bonusAcceptor;

    public LottoController(Map<LottoNumberMatchCount, Integer> prizeMoney, MoneyToBuyAcceptor moneyToBuyAcceptor,
                           LottoNumberGenerator lottoNumberGenerator, WinningNumbersAcceptor winningNumbersAcceptor,
                           BonusAcceptor bonusAcceptor) {
        this.prizeMoney = prizeMoney;
        this.moneyToBuyAcceptor = moneyToBuyAcceptor;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.winningNumbersAcceptor = winningNumbersAcceptor;
        this.bonusAcceptor = bonusAcceptor;
    }

    public void run() {
        final MoneyToBuy moneyToBuy = userInputMoneyToBuy();
        final LottoTicketsBucket lottoTicketsBucket = new LottoTicketsBucket(moneyToBuy);
        while (lottoTicketsBucket.canBuyMoreLotto()) {
            final LottoTicket newLottoTicket = buyOneLottoTicket(lottoTicketsBucket);
            displayEachLottoTicket(newLottoTicket);
        }
        final WinningNumbers winningNumbersBefore = userInputWinningNumbers();
        final WinningNumbers winningNumbers = userInputBonusNumber(winningNumbersBefore);
        displayLottoResult(lottoTicketsBucket, winningNumbers, moneyToBuy);
    }

    private MoneyToBuy userInputMoneyToBuy() {
        return moneyToBuyAcceptor.accept();
    }

    private LottoTicket buyOneLottoTicket(LottoTicketsBucket lottoTicketsBucket) {
        final List<LottoNumber> lottoNumbers = lottoNumberGenerator.generate();
        final LottoTicket newLottoTicket = new LottoTicket(lottoNumbers);
        lottoTicketsBucket.buyOneLotto(newLottoTicket);
        return newLottoTicket;
    }

    private void displayEachLottoTicket(LottoTicket lottoTicket) {
        LottoTicketPrinter.print(lottoTicket);
    }

    private WinningNumbers userInputWinningNumbers() {
        return winningNumbersAcceptor.accept();
    }

    private WinningNumbers userInputBonusNumber(WinningNumbers winningNumbers) {
        final LottoNumber bonusNumber = bonusAcceptor.accept();
        winningNumbers.setBonus(bonusNumber);
        return new WinningNumbers(winningNumbers);
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
