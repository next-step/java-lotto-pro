package lotto;

import lotto.domain.*;
import lotto.view.*;

public class LottoController {
    public static void main(String[] args) {
        Money money = new Money(LottoPurchaseView.input());
        final int lottoManualPurchaseCount = LottoManualPurchaseCountView.input();

        final LottoManual lottoManual = new LottoManual(lottoManualPurchaseCount, money);

        Lottos lottos = LottoStore.purchase(money, lottoManual.createLottos(LottoManualPurchaseView.input(lottoManualPurchaseCount)));

        LottoPurchaseListView.print(lottos, lottoManual);

        WinningLotto winningLotto = new WinningLotto(LottoWinningNumberView.input(), LottoWinningBonusNumberView.input());

        LottoWinnerStatisticView.print(lottos.winningResult(winningLotto), money);
    }
}
