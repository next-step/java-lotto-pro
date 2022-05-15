package lotto.controller;

import lotto.domain.LottoScore;
import lotto.domain.LottoShop;
import lotto.domain.Lottos;
import lotto.domain.ProfitRate;
import lotto.domain.WinningNumbers;
import lotto.domain.Winnings;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void play() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        Lottos lottos = LottoShop.sale(purchaseAmount);
        OutputView.printPurchaseCount(lottos.getLottos().size());
        OutputView.printLottoNumbers(lottos.getLottos());

        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers());
        LottoScore lottoScore = lottos.calculateLottoScore(winningNumbers);
        OutputView.printLottoStats(lottoScore.getLottoScoreMap());

        Winnings winnings = lottoScore.getWinnings();
        ProfitRate profitRate = new ProfitRate(winnings, purchaseAmount);
        OutputView.printProfitRate(profitRate.getRate());
    }
}
