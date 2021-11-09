package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoShop lottoShop = new LottoShop();

        Money money = inputView.getPurchaseMoney();
        int lottoTicketCount = lottoShop.getPurchasableLottoTicketCount(money);
        resultView.printLottoTicketCount(lottoTicketCount);

        LottoTickets lottoTickets = lottoShop.createLottoTickets(new PurchaseCount(lottoTicketCount));
        resultView.printLottoTickets(lottoTickets);

        WinningNumbers winningNumbers = inputView.getWinningNumbers();

        resultView.printLottoRewardResult(winningNumbers, lottoTickets);
    }
}
