package lotto;

  import lotto.ui.InputView;
  import lotto.ui.ResultView;

public class DestinyMatch {
    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        String inputMoney = inputView.getInputString();
        Buyer buyer = new Buyer(inputMoney);

        resultView.printBuyLottoCountMessage(buyer.buyLotto());
        resultView.printBuyLotto(buyer.getLottos());

        String inputLottoNumbers = inputView.getInputWinningNumbers();
        String inputBonusNumber = inputView.getInputBonusNumbers();
        WinningMatcher winningMatcher = new WinningMatcher(buyer, new LottoNumbers(inputLottoNumbers), inputBonusNumber);
        winningMatcher.printWinningStatistics();
        winningMatcher.printProfit(inputMoney);
    }
}
