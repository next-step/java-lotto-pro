package lotto;

import lotto.domain.LottoPurchase;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.printInputPurchasePrice();
        String purchasePriceText = inputView.inputPurchasePrice();

        LottoPurchase lottoPurchase = new LottoPurchase(purchasePriceText);
        resultView.printPurchaseLottoCount(lottoPurchase.issuedLottoCount());
        resultView.printIssuedLottoNumber(lottoPurchase.issuedLottoNumbers());
    }
}
