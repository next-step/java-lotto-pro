package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void simulateLotto(){
        Money money = new Money(InputView.readMoney());
        Lottos lottos = purchaseLottos(money.lottoCountToBuy());
        OutputView.printPurchasedLottos(lottos);
    }

    private static Lottos purchaseLottos(int count) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < count; i++) {
            lottos.addRandomLotto();
        }
        return lottos;
    }
}
