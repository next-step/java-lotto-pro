package lotto;

import lotto.domain.*;
import lotto.domain.Number;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoShop lottoShop = new LottoShop();

        Money money = inputView.getPurchaseMoney();

        PurchaseCount manualPurchaseCount = inputView.getManualPurchaseCount();

        List<List<Integer>> manualNumbers = inputView.getManualNumbers(manualPurchaseCount);

        PurchaseCounts purchaseCounts = lottoShop.countPurchasableLotto(money, manualPurchaseCount);
        resultView.printLottoTicketCount(purchaseCounts);

        LottoTickets manualLottoTickets = lottoShop.createManualLottoTickets(manualNumbers);
        LottoTickets autoLottoTickets = lottoShop.createAutoLottoTickets(purchaseCounts.getAutoPurchaseCount());
        LottoTickets totalLottoTickets = manualLottoTickets.add(autoLottoTickets);
        resultView.printLottoTickets(totalLottoTickets);

        WinningNumbers winningNumbers = inputView.getWinningNumbers();
        Number bonusNumber = inputView.getBonusNumber();

        resultView.printLottoRewardResult(winningNumbers, totalLottoTickets, bonusNumber);
    }
}
