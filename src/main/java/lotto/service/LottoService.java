package lotto.service;

import lotto.domain.lotto.LottoTicketVendingMachine;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.purchase.PurchaseAmount;
import lotto.domain.purchase.PurchaseMoney;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningResult;
import lotto.domain.winning.WinningStatistics;
import lotto.util.StringUtil;

import java.util.List;

public class LottoService {

    private final LottoTicketVendingMachine vendingMachine;

    public LottoService() {
        this.vendingMachine = new LottoTicketVendingMachine();
    }

    public PurchaseMoney getPurchaseMoney(String input) {
        int money = StringUtil.parseIntFrom(input);
        return new PurchaseMoney(money);
    }

    public LottoTickets issueTickets(PurchaseAmount purchaseAmount) {
        return vendingMachine.issueTickets(purchaseAmount.getAutoTicketAmount());
    }

    public WinningResult getWinningResult(String input, LottoTickets lottoTickets) {
        List<Integer> numbers = StringUtil.splitParseInt(input);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);

        WinningResult winningResult = new WinningResult(winningNumbers);
        winningResult.aggregate(lottoTickets);

        return winningResult;
    }

    public float profitRate(WinningResult winningResult, PurchaseMoney purchaseMoney) {
        WinningStatistics winningStatistics = new WinningStatistics(winningResult);
        return winningStatistics.profitRate(purchaseMoney);
    }
}
