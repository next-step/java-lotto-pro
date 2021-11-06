package lotto;

import lotto.model.GameCount;
import lotto.model.Games;
import lotto.model.Checker;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        GameCount gameCount = new GameCount(purchaseAmount);
        Games games = new Games(gameCount.getValue());
        WinningNumbers winningNumbers = InputView.inputWinningNumbers();
        Checker checker = new Checker(games, winningNumbers);
        ResultView.printResult(checker.getResults());
        ResultView.printEarningRate(purchaseAmount);
    }

}
