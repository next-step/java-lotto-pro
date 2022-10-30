package lotto;

import java.util.List;

public class LottoGameMain {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int payMoney = inputView.inputPay();
        LottoGame lottoGame = new LottoGame(payMoney, new AutoLottoNumberGenerator());

        int purchaseCount = lottoGame.getPurchaseCount();
        resultView.printResultPay(purchaseCount);

        List<LottoNumber> lottoNumbers = lottoGame.purchaseLotto(purchaseCount);
        resultView.printResultPurchase(lottoNumbers);

        Prize prize = new Prize(inputView.inputWinningNumberLastWeek());
        prize.countPrize(lottoNumbers);

        resultView.printResultWinningStatistics(payMoney, prize);
    }
}
