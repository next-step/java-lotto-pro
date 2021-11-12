package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LotteryGame {
    public static void main(String[] args) {
        int numberOfTicket = InputView.payMoney();
        int numberOfManualTickets = InputView.enterNumberOfManualLotteryTickets();
        int numberOfAutoTickets = numberOfTicket - numberOfManualTickets;
        InputView.enterManualLotteryNumbersMessage();
        PurchaseLotteryTicket purchaseLotteryTicket = new PurchaseLotteryTicket();
        for (int i = 0; i < numberOfManualTickets; i++) {
            purchaseLotteryTicket.add(LotteryNumbers.createManualLotteryNumber(InputView.enterManualLotteryNumbers()));
        }
        for (int i = 0; i < numberOfAutoTickets; i++) {
            purchaseLotteryTicket.add(LotteryTicketFactory.createLotteryTicket());
        }
        InputView.printLotteryTicketType(numberOfManualTickets, numberOfAutoTickets);
        for (int i = 0; i < numberOfTicket; i++) {
            InputView.printLottoTicketNumber(purchaseLotteryTicket.get(i).getLotteryNumber());
        }
        WinningNumber winningNumber = WinningNumber.createWinningNumber(InputView.enterWinningNumber(), InputView.enterBonusNumber());
        ResultView.printWinningStatistics(numberOfTicket, purchaseLotteryTicket, winningNumber);
    }
}
