package lotto.controller;

import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.view.View;

public class LottoController {
    private final LottoList lottos;
    private final View view;

    public LottoController() {
        this.lottos = new LottoList();
        this.view = new View();
    }

    public void run() {
        Money money = new Money(view.insertMoney());
        view.printLottoCount(money.getBuyableLottoCount());
        lottos.buyLottos(money.getBuyableLottoCount());
        view.print(lottos.toString());
    }
}
