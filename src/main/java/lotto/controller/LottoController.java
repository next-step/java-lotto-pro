package lotto.controller;

import lotto.model.*;

import static lotto.utils.InputUtils.*;
import static lotto.view.InputView.readPurchaseAmount;
import static lotto.view.InputView.readWinningNumbers;

public class LottoController {

    public static void run() {
        Purchase purchaseInfo = Purchase.createPurchase(convertToInteger(readPurchaseAmount()));
        purchaseInfo.printPurchaseCount();

        Lottos lottos = purchaseInfo.createLottos();
        lottos.printLottos();

        LottoNumbers winningNumbers = LottoNumbers.createWinningNumbers(convertToIntegerList(splitWithDelimiter(readWinningNumbers())));
        System.out.println(winningNumbers);

        RankCount rankCount = lottos.rankCount(winningNumbers);
        System.out.println(rankCount);
        Earning earningRate = rankCount.earningRate(purchaseInfo);

        Statistics statistics = Statistics.of(rankCount, earningRate);
        statistics.printStatistics();
    }
}
