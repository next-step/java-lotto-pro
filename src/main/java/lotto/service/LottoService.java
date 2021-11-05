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

    public PurchaseMoney getPurchaseMoney(String inputMoney) {
        int money = StringUtil.parseIntFrom(inputMoney);
        return new PurchaseMoney(money);
    }

    public PurchaseAmount getPurchaseAmount(PurchaseMoney purchaseMoney, String inputManualAmount) {
        int manualAmount = StringUtil.parseIntFrom(inputManualAmount);
        return purchaseMoney.getPurchaseAmount(manualAmount);
    }

    public LottoTickets issueTickets(PurchaseAmount purchaseAmount) {
        return vendingMachine.issueTickets(purchaseAmount.getAutoTicketAmount());
    }

    public WinningNumbers getWinningNumbers(String inputWinningNumbers, String inputBonusNumber) {
        List<Integer> winningNumbers = StringUtil.splitParseInt(inputWinningNumbers);
        int bonusNumber = StringUtil.parseIntFrom(inputBonusNumber);
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public WinningResult getWinningResult(WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        WinningResult winningResult = new WinningResult(winningNumbers);
        winningResult.aggregate(lottoTickets);

        return winningResult;
    }

    public float profitRate(WinningResult winningResult, PurchaseMoney purchaseMoney) {
        WinningStatistics winningStatistics = new WinningStatistics(winningResult);
        return winningStatistics.profitRate(purchaseMoney);
    }
}
