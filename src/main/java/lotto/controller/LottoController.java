package lotto.controller;

import lotto.constant.ErrorMessageConst;
import lotto.domain.*;
import lotto.utils.CustomParseUtils;
import lotto.generator.LottosGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static void simulateLotto(){
        Money money = new Money(CustomParseUtils.stringToInteger(InputView.readMoney()));
        Lottos lottos = LottosGenerator.purchaseManualAndAutoLottos(money, readManualLottos(money.maxLottoCount()));
        OutputView.printPurchasedLottos(lottos);

        Lotto winningLotto = readWinningNumbers();
        LottoNumber bonusNumber = new LottoNumber(CustomParseUtils.stringToInteger(InputView.readBonusNumber()));
        LottoResult result = new LottoResult(lottos, winningLotto, bonusNumber);
        OutputView.printLottoResult(result, money.calculateProfit(result.winningPrice()));
    }

    private static List<Lotto> readManualLottos(int maxCount) {
        int manualCount = readValidManualCount(maxCount);
        return readManualNumbers(manualCount);
    }

    private static int readValidManualCount(int maxCount) {
        int manualCount = CustomParseUtils.stringToInteger(InputView.readManualLottosCount());
        if (manualCount > maxCount) {
            throw new IllegalArgumentException(ErrorMessageConst.ERROR_INVALID_EXCEED_MAX_LOTTO_COUNT);
        }
        return manualCount;
    }

    private static List<Lotto> readManualNumbers(int manualCount) {
        List<Lotto> manualLottos = new ArrayList<>();
        InputView.guideMessageToReadManualLottoNumbers();
        for (int i = 0; i < manualCount; i++) {
            List<Integer> manualNumbers = CustomParseUtils.stringToIntegerList(InputView.readSimpleLottoNumbers());
            manualLottos.add(new Lotto(manualNumbers));
        }
        return manualLottos;
    }

    private static Lotto readWinningNumbers(){
        List<Integer> winningNumbers = CustomParseUtils.stringToIntegerList(InputView.readLottoWinningNumber());
        return new Lotto(winningNumbers);
    }
}
