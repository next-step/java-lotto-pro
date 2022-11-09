package lotto;

  import lotto.ui.InputView;
  import lotto.ui.ResultView;

public class DestinyMatch {
    private InputView inputView;
    private ResultView resultView;
    private String inputMoney;
    private String directInputLotto;
    private Buyer buyer;

    public DestinyMatch() {
        inputView = new InputView();
        resultView = new ResultView();
        this.inputMoney = inputView.getInputString();
        this.directInputLotto = inputView.getDirectInputLottoNumber();
        this.buyer = new Buyer(inputMoney);
    }

    public void start() {
        buyer.buyLotto(directInputLotto);

        resultView.printBuyLottoCountMessage(buyer.buyLotto(), directInputLotto);
        resultView.printBuyLotto(buyer.getLottos());

        resultPrint(inputView.getInputWinningNumbers(), inputView.getInputBonusNumbers());
    }

    private void resultPrint(String inputLottoNumbers, String inputBonusNumber) {
        WinningMatcher winningMatcher = new WinningMatcher(buyer, new WinningLotto(inputLottoNumbers, inputBonusNumber));
        resultView.printWinningStatistics(winningMatcher);
        resultView.printProfit(winningMatcher, inputMoney);
    }
}
