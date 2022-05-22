package lotto.controller;

import lotto.generator.WinningLottoNumbersGenerator;
import lotto.model.*;
import lotto.view.ResultView;

import static lotto.utils.InputUtils.*;
import static lotto.view.InputView.readPurchaseAmount;

public class LottoController {

    public static void run() {
        Purchase purchaseInfo = Purchase.createPurchase(convertToInteger(readPurchaseAmount()));
        ResultView.printPurchaseCountView(purchaseInfo.getCount());

        Lottos lottos = purchaseInfo.createLottos();
        lottos.printLottos();

        LottoNumbers winningNumbers = LottoNumbers.createLottoNumbers(new WinningLottoNumbersGenerator());

        RankCount rankCount = lottos.rankCount(winningNumbers);
        Earning earningRate = rankCount.earningRate(purchaseInfo);

        Statistics statistics = Statistics.of(rankCount, earningRate);
        ResultView.printStatistics(statistics);
    }
}
