package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class LottoController {
    public static void simulateLotto(){
        Money money = new Money(InputView.readMoney());
    }
}
