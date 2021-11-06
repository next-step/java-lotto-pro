package lotto;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LotteryGame {
    public static void main(String[] args) {
        int numberOfTicket = InputView.payMoney();
        List<LotteryTicket> purchaseList = new ArrayList<>();
        for(int i = 0 ; i < numberOfTicket ; i++) {
            purchaseList.add(LotteryTicketCreator.createLotteryTicket());
            purchaseList.get(i).printLottoNumber();
        }
        String[] winningNumber = InputView.enterWinningNumber();
    }
}
