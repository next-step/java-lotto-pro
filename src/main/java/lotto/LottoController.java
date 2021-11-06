package lotto;

import lotto.domain.*;
import lotto.view.LottoPurchaseListView;
import lotto.view.LottoPurchaseView;
import lotto.view.LottoWinningNumberView;
import lotto.view.LottoWinnerStatisticView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        int purchaseAmount = LottoPurchaseView.input();
        Lottos lottos = LottoStore.purchase(purchaseAmount);

        LottoPurchaseListView.print(lottos);

        List<Integer> winnerNumber = LottoWinningNumberView.input();
        LottoWinnerStatisticView.print(lottos.winningResult(winnerNumber), purchaseAmount);
    }
}
