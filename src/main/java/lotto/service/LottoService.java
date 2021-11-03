package lotto.service;

import lotto.domain.lotto.LottoTicketVendingMachine;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.purchase.PurchaseMoney;
import lotto.domain.statistics.WinningNumbers;
import lotto.domain.statistics.WinningResult;
import lotto.domain.statistics.WinningStatistics;

import java.util.List;

public class LottoService {

    private final LottoTicketVendingMachine vendingMachine;

    public LottoService() {
        this.vendingMachine = new LottoTicketVendingMachine();
    }

    public int getTicketAmount(int money) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(money);
        return purchaseMoney.getPurchaseAmount();
    }

    public LottoTickets issueTickets(int purchaseAmount) {
        return vendingMachine.issueTickets(purchaseAmount);
    }

    public WinningResult getWinningResult(List<Integer> numbers, LottoTickets lottoTickets) {
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        WinningResult winningResult = new WinningResult(winningNumbers);
        winningResult.aggregate(lottoTickets);
        return winningResult;
    }

    public float profitRate(WinningResult winningResult, int purchaseAmount) {
        WinningStatistics winningStatistics = new WinningStatistics(winningResult);
        return winningStatistics.profitRate(purchaseAmount);
    }
}
