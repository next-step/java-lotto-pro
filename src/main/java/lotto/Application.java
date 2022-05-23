package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Application {

    public static void main(String[] args) {
        new Application().startGame();
    }

    private void startGame() {
        int purchasePrice = InputView.getPurchasePrice();
        NumberGenerator numberGenerator = new LottoNumberGenerator();
        LottoGame game = new LottoGame(purchasePrice, numberGenerator);
        ResultView.printTicketCount(game.getTicketCount());
        game.printTickets();

        ResultView.printEmptyLine();
        String winnerNumbers = InputView.getWinnerNumbers();
        int bonusBallNumber = InputView.getBonusBallNumber();
        game.generateGameResult(new WinnerTicket(winnerNumbers, new LottoNumber(bonusBallNumber)));

        ResultView.printEmptyLine();
        game.printGameResult();
    }
}
