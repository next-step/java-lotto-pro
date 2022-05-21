package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Application {

    public static void main(String[] args) {
        new Application().startGame();
    }

    private void startGame() {
        int purchasePrice = InputView.getPurchasePrice();
        LottoGame game = new LottoGame(purchasePrice);
        ResultView.printTicketCount(game.getTicketCount());
        game.printTickets();

        System.out.println();
        String winnerNumbers = InputView.getWinnerNumbers();
        game.generateGameResult(new WinnerTicket(winnerNumbers));

        System.out.println();
        game.printGameResult();
    }
}
