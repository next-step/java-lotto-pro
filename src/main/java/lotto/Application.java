package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.NumberGenerator;
import lotto.domain.WinnerTicket;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Application {

    public static void main(String[] args) {
        new Application().startGame();
    }

    private void startGame() {
        int purchasePrice = InputView.getPurchasePrice();
        int bonusBallNumber = InputView.getBonusBallNumber();
        NumberGenerator numberGenerator = new LottoNumberGenerator();
        LottoGame game = new LottoGame(purchasePrice, numberGenerator);
        ResultView.printTicketCount(game.getTicketCount());
        game.printTickets();

        System.out.println();
        String winnerNumbers = InputView.getWinnerNumbers();
        game.generateGameResult(new WinnerTicket(winnerNumbers));

        System.out.println();
        game.printGameResult();
    }
}
