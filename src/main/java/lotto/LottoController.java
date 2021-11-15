package lotto;

import lotto.domain.*;
import lotto.view.*;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        Money money = new Money(LottoPurchaseView.input());
        final int lottoManualPurchaseCount = LottoManualPurchaseCountView.input();

        List<List<Integer>> manualLottoNumbers = LottoManualPurchaseView.input(lottoManualPurchaseCount);

        Lottos lottos = LottoStore.purchase(money, lottoManualPurchaseCount, manualLottoNumbers);

        LottoPurchaseListView.print(lottos, manualLottoNumbers.size());

        WinningLotto winningLotto = new WinningLotto(LottoWinningNumberView.input(), LottoWinningBonusNumberView.input());

        LottoWinnerStatisticView.print(lottos.winningResult(winningLotto), money);
    }
}
