package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static void play() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        Price price = new Price(purchaseAmount);

        Quantity manualLottoQuantity = new Quantity(InputView.inputManualLottoQuantity());
        Lottos manualLottos = LottoShop.buyManualLottos(InputView.inputManualLottoNumber(
            manualLottoQuantity.getQuantity()), price);
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
