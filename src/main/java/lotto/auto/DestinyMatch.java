package lotto.auto;

  import lotto.auto.ui.InputView;
  import lotto.auto.ui.ResultView;

public class DestinyMatch {
    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        String inputMoney = inputView.getInputString();
        Buyer buyer = new Buyer(inputMoney);

        resultView.printBuyLottoCountMessage(buyer.buyLotto());
        resultView.printBuyLotto(buyer.getLottos());

        WinningMatcher winningMatcher = new WinningMatcher(buyer, new LottoNumbers(inputView.getInputWinningNumbers()));
        winningMatcher.printWinningStatistics();
        winningMatcher.printProfit(inputMoney);
    }
}
