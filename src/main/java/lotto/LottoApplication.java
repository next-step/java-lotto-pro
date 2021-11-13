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
        LottoNumbers firstPrizeNumbers = InputView.inputFirstPrizeNumbers();
        BonusNumber bonusNumber = InputView.inputBonusNumber(firstPrizeNumbers);
        WinnerNumbers winningNumbers = new WinnerNumbers(firstPrizeNumbers, bonusNumber);
        Checker checker = new Checker(games, winningNumbers);
        Integer totalPrizeMoney = ResultView.printResult(checker.getResults());
        ResultView.printEarningRate(purchaseAmount, totalPrizeMoney);
    }

}
