package lotto;

import java.util.List;

public class LottoGameMain {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static LottoGame lottoGame;

    public static void main(String[] args) {
        int payMoney = inputView.inputPay();
        lottoGame = new LottoGame(payMoney, new LottoNumberGenerator());
        int purchaseCount = lottoGame.purchaseCount();
        resultView.resultPay(purchaseCount);
        List<LottoNumber> lottoNumbers = lottoGame.purchaseLotto(purchaseCount);
        resultView.resultPurchase(lottoNumbers);
        LottoNumbers purchasedLottoNumber = new LottoNumbers(lottoNumbers);
        purchasedLottoNumber.countPrize(inputView.inputWinningNumberLastWeek());
        resultView.resultWinningStatistics(payMoney, purchasedLottoNumber);
    }
}
