package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LotteryGame {
    public static void main(String[] args) {
        int numberOfTicket = InputView.payMoney();
        PurchaseLotteryTicket purchaseLotteryTicket = new PurchaseLotteryTicket();
        for (int i = 0; i < numberOfTicket; i++) {
            purchaseLotteryTicket.add(LotteryTicketFactory.createLotteryTicket());
            InputView.printLottoTicketNumber(purchaseLotteryTicket.get(i).getLotteryNumber());
        }
        WinningNumber winningNumber = WinningNumber.createWinningNumber(InputView.enterWinningNumber());
        ResultView.printWinningStatistics(numberOfTicket, purchaseLotteryTicket, winningNumber);
    }
}
