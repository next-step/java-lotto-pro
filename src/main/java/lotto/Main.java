package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Main {

    public static void main(String[] args) {
        int purchasePrice = InputView.getPurchasePrice();
        LottoGame game = new LottoGame(purchasePrice);
        ResultView.printTicketCount(game.getTicketCount());
        game.printTicketNumbers();
        System.out.println();
        String winnerNumbers = InputView.getWinnerNumbers();
        game.setWinnerNumbers(winnerNumbers);
        game.generateGameResult();

        System.out.println();
        game.printGameResult();
    }
}
