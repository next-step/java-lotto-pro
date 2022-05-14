package lotto;

import lotto.domain.Lotties;
import lotto.domain.Money;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        Money purchaseAmount = InputView.getPurchaseAmount();
        Lotties myLotties = LottoGame.purchase(purchaseAmount);


    }
}
