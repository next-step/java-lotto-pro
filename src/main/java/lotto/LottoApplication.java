package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        GameCount gameCount = new GameCount(purchaseAmount);
        ResultView.printPurchasedGameCount(gameCount.getValue());
        Games games = new Games(gameCount.getValue());
        WinningNumbers winningNumbers = InputView.inputWinningNumbers();
        WinningNumber bonusNumber = InputView.inputBonusNumber(winningNumbers);
        Checker checker = new Checker(games, winningNumbers, bonusNumber);
        ResultView.printResult(checker.getResults());
        ResultView.printEarningRate(purchaseAmount);
    }

}
