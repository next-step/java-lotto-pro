package lotto.controller;

import lotto.generator.AutoLottoNumbersGenerator;
import lotto.generator.ManualLottoNumbersGenerator;
import lotto.generator.WinningLottoNumbersGenerator;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.utils.InputUtils.convertToInteger;
import static lotto.view.InputView.*;

public class LottoController {

    public static void run() {
        Purchase purchaseInfo = purchaseLotto();
        Lottos allLottos = createAllLottos(purchaseInfo);
        ResultView.printLottos(allLottos);

        LottoNumbers winningNumbers = LottoNumbers.createLottoNumbers(new WinningLottoNumbersGenerator());
        LottoNumber bonusNumber = LottoNumber.of(convertToInteger(readBonusNumber()));

        RankCount rankCount = allLottos.rankCount(winningNumbers, bonusNumber);
        Earning earningRate = rankCount.earningRate(purchaseInfo);

        Statistics statistics = Statistics.of(rankCount, earningRate);
        ResultView.printStatistics(statistics);
    }

    private static Purchase purchaseLotto() {
        int purchaseAmount = convertToInteger(readPurchaseAmount());
        int manualCount = convertToInteger(readManualPurchaseCount());
        return Purchase.createPurchase(purchaseAmount, manualCount);
    }

    private static Lottos createAllLottos(Purchase purchase) {
        InputView.printManualLottoNumbersInputMessage();
        Lottos manualLottos = purchase.createLottos(new ManualLottoNumbersGenerator(), purchase.getManualCount());

        ResultView.printPurchaseCountView(purchase);

        Lottos autoLottos = purchase.createLottos(new AutoLottoNumbersGenerator(), purchase.getAutoCount());
        return manualLottos.union(autoLottos);
    }

}
