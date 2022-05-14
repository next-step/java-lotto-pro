package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoGame {

    final static int TICKET_UNIT_PRICE = 1000;

    private int purchasePrice;

    LottoGame(int purchasePrice) {
        isValidPurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
        ResultView.printTicketCount(this.getTicketCount());
    }

    public int getTicketCount() {
        return this.purchasePrice / TICKET_UNIT_PRICE;
    }

    private static void isValidPurchasePrice(int purchasePrice) {
        if (purchasePrice < TICKET_UNIT_PRICE) {
            throw new RuntimeException("Can't buy ticket. Game will exit.");
        }
    }
}
