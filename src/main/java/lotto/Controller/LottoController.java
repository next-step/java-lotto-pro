package lotto.Controller;

import lotto.domain.Money;
import lotto.view.LottoInputView;

public class LottoController {

    public static void start() {
        Money money = new Money(Integer.parseInt(LottoInputView.readMoney()));
    }
}
