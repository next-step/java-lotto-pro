package lotto;

import lotto.domain.*;
import lotto.domain.Number;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Optional;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoShop lottoShop = new LottoShop();

        Money money = inputView.getPurchaseMoney();
        PurchaseCounts purchaseCounts = inputView.getPurchaseCounts(money);

        List<List<Integer>> manualNumbers = inputView.getManualNumbers(purchaseCounts.getManualPurchaseCount());
        List<LottoTicket> manualLottoTickets = lottoShop.createManualLottoTickets(manualNumbers);

        resultView.printLottoTicketCount(purchaseCounts);

        List<LottoTicket> autoLottoTickets = lottoShop.createAutoLottoTickets(purchaseCounts.getAutoPurchaseCount());
        manualLottoTickets.addAll(autoLottoTickets);
        LottoTickets totalLottoTickets = new LottoTickets(manualLottoTickets);
        resultView.printLottoTickets(totalLottoTickets);

        WinningNumbers winningNumbers = inputView.getWinningNumbers();
        Number bonusNumber = inputView.getBonusNumber(winningNumbers);

        resultView.printLottoRewardResult(winningNumbers, totalLottoTickets, bonusNumber);
    }
}
