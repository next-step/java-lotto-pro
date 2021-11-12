package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        GameCount gameCount = new GameCount(purchaseAmount);
        ManualGameCount manualGameCount = InputView.inputPurchaseManualGameCount(gameCount);
        ManualNumbers manualNumbers = InputView.inputManualNumbers(manualGameCount.getValue());
        ResultView.printPurchasedGameCount(gameCount.getValue(), manualGameCount.getValue());
        Games games = new Games(gameCount.getValue(), manualNumbers);
        ResultView.printPurchaseGames(games.getList());
        WinnerNumbers winningNumbers = InputView.inputWinningNumbers();
        Checker checker = new Checker(games, winningNumbers);
        ResultView.printResult(checker.getResults());
        ResultView.printEarningRate(purchaseAmount);
    }

}
