package lotto.controller;

import lotto.domain.Money;
import lotto.view.View;

public class LottoController {
    private final View view;

    public LottoController() {
        this.view = new View();
    }

    public void run() {
        Money money = new Money(view.insertMoney());
        view.printLottoCount(money.getBuyableLottoCount());
    }
}
