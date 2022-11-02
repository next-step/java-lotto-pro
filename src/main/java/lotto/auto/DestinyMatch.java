package lotto.auto;

  import lotto.auto.ui.InputView;

public class DestinyMatch {
    public void start() {
        InputView inputView = new InputView();
        String inputMoney = inputView.getInputString();

        WinningMatcher winningMatcher = new WinningMatcher(new Buyer(inputMoney), new LottoNumbers(inputView.getInputWinningNumbers()));
        winningMatcher.printWinningStatistics();
        winningMatcher.printProfit(inputMoney);
    }
}
