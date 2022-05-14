package lotto;

import lotto.domain.Lotties;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
    public static void main(String[] args) {
        Money purchaseAmount = InputView.getPurchaseAmount();
        Lotties myLotties = LottoGame.purchase(purchaseAmount);
        ResultView.printPurchaseLotties(myLotties);

    }
}
