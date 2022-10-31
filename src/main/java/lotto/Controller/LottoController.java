package lotto.Controller;

import lotto.domain.LottoCreator;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.LottoInputView;
import lotto.view.LottoOutPutView;

public class LottoController {

    public static void start() {
        Money money = new Money(Integer.parseInt(LottoInputView.readMoney()));
        Lottos lottos = LottoCreator.buyLottos(money.lottoCount());
        LottoOutPutView.writeBuyLottos(lottos);
    }
}
