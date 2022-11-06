package lotto;

  import lotto.ui.InputView;
  import lotto.ui.ResultView;

public class DestinyMatch {
    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        String inputMoney = inputView.getInputString();
        String directInputLotto = inputView.getDirectInputLottoNumber();
        Buyer buyer = new Buyer(inputMoney, directInputLotto);

        resultView.printBuyLottoCountMessage(buyer.buyLotto(), directInputLotto);
        resultView.printBuyLotto(buyer.getLottos());

        String inputLottoNumbers = inputView.getInputWinningNumbers();
        String inputBonusNumber = inputView.getInputBonusNumbers();

        WinningMatcher winningMatcher = new WinningMatcher(buyer, new WinningLotto(inputLottoNumbers, inputBonusNumber));
        resultView.printWinningStatistics(winningMatcher);
        resultView.printProfit(winningMatcher, inputMoney);
    }
}
