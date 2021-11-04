package lotto.service;

import lotto.domain.lotto.LottoTicketVendingMachine;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.purchase.PurchaseAmount;
import lotto.domain.purchase.PurchaseMoney;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningResult;
import lotto.domain.winning.WinningStatistics;
import lotto.util.StringUtil;

public class LottoService {

    private final LottoTicketVendingMachine vendingMachine;
    private LottoTickets lottoTickets;

    public LottoService() {
        this.vendingMachine = new LottoTicketVendingMachine();
    }

    public PurchaseMoney getPurchaseMoney(String input) {
        int money = StringUtil.parseIntFrom(input);
        return new PurchaseMoney(money);
    }

    public LottoTickets issueTickets(PurchaseAmount purchaseAmount) {
        this.lottoTickets = vendingMachine.issueTickets(purchaseAmount.getAutoTicketAmount());
        return lottoTickets;
    }

    public WinningResult getWinningResult(String inputWinningNumbers, String inputBonusNumber) {
        WinningNumbers winningNumbers = new WinningNumbers(StringUtil.splitParseInt(inputWinningNumbers));
        BonusNumber bonusNumber = new BonusNumber(winningNumbers, StringUtil.parseIntFrom(inputBonusNumber));

        WinningResult winningResult = new WinningResult(winningNumbers, bonusNumber);
        winningResult.aggregate(lottoTickets);

        return winningResult;
    }

    public float profitRate(WinningResult winningResult, PurchaseMoney purchaseMoney) {
        WinningStatistics winningStatistics = new WinningStatistics(winningResult);
        return winningStatistics.profitRate(purchaseMoney);
    }
}
