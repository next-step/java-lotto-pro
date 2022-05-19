package lotto.controller;

import lotto.domain.LottoShop;
import lotto.domain.LottoNo;
import lotto.domain.LottoScore;
import lotto.domain.Lottos;
import lotto.domain.ManualLottoCount;
import lotto.domain.Price;
import lotto.domain.WinningNumbers;
import lotto.domain.Winnings;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void play() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        Price price = new Price(purchaseAmount);

        ManualLottoCount manualLottoCount = new ManualLottoCount(InputView.inputManualLottoCount());
        Lottos manualLottos = LottoShop.buyManualLottos(InputView.inputManualLottoNumber(
            manualLottoCount.getManualLottoCount()), price);
        Lottos autoLottos = LottoShop.buyAutoLottos(price);

        OutputView.printPurchaseCountByLottoType(manualLottos.size(), autoLottos.size());
        OutputView.printLottoNumbers(autoLottos.getLottos());
        Lottos lottos = Lottos.merge(manualLottos, autoLottos);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers());
        LottoNo bonusNumber = new LottoNo(InputView.inputBonusNumber());
        winningNumbers.addBonusNumber(bonusNumber);

        LottoScore lottoScore = lottos.calculateLottoScore(winningNumbers);
        OutputView.printLottoStats(lottoScore.getRankMap());

        Winnings winnings = lottoScore.getWinnings();
        OutputView.printProfitRate(winnings.profitRate(purchaseAmount));
    }
}
