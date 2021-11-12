package lotto;

import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.*;

public class LottoController {
    public static void main(String[] args) {
        Money money = new Money(LottoPurchaseView.input());
        Lottos lottos = LottoStore.purchase(money);

        LottoPurchaseListView.print(lottos);

        WinningLotto winningLotto = new WinningLotto(LottoWinningNumberView.input(), LottoWinningBonusNumberView.input());

        LottoWinnerStatisticView.print(lottos.winningResult(winningLotto), money);
    }
}
