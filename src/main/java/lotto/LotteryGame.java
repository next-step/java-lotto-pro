package lotto;

import lotto.view.InputView;

public class LotteryGame {
    public static void main(String[] args) {
        int numberOfTicket = InputView.payMoney();
        PurchaseLotteryTicket purchaseList = new PurchaseLotteryTicket();
        for(int i = 0 ; i < numberOfTicket ; i++) {
            purchaseList.add(LotteryTicketCreator.createLotteryTicket());
            purchaseList.get(i).printLottoNumber();
        }
        String[] winningNumber = InputView.enterWinningNumber();
    }
}
