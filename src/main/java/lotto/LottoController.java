package lotto;

import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.LottoPurchaseListView;
import lotto.view.LottoPurchaseView;
import lotto.view.LottoWinnerStatisticView;
import lotto.view.LottoWinningBonusNumberView;
import lotto.view.LottoWinningNumberView;

public class LottoController {
    public static void main(String[] args) {
        Money money = new Money(LottoPurchaseView.input());
        Lottos lottos = LottoStore.purchase(money);

        LottoPurchaseListView.print(lottos);

        LottoWinnerStatisticView.print(lottos.winningResult(LottoWinningNumberView.input(), LottoWinningBonusNumberView.input()), money);
    }
}
