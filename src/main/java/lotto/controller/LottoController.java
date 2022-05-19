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
        Money money = readMoney();
        LottoCount manualCount = readValidManualCount(money.maxLottoCount());
        Lottos lottos = LottosGenerator.purchaseManualAndAutoLottos(money, readManualNumbers(manualCount));
        OutputView.printPurchasedLottos(lottos, manualCount);

        Lotto winningLotto = readWinningNumbers();
        LottoNumber bonusNumber = new LottoNumber(CustomParseUtils.stringToInteger(InputView.readBonusNumber()));
        LottoResult result = new LottoResult(lottos, winningLotto, bonusNumber);
        OutputView.printLottoResult(result, money.calculateProfit(result.winningPrice()));
    }

    private static Money readMoney() {
        Money money = new Money(CustomParseUtils.stringToInteger(InputView.readMoney()));
        if (money.maxLottoCount().isLessThan(LottoCount.from(0))) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessageConst.ERROR_INVALID_MONEY_MINIMUM_VALUE, Money.LOTTO_PRICE)
            );
        }
        return money;
    }

    private static LottoCount readValidManualCount(LottoCount maxCount) {
        LottoCount manualCount = LottoCount.from(CustomParseUtils.stringToInteger(InputView.readManualLottosCount()));
        if (manualCount.isGreaterThan(maxCount)) {
            throw new IllegalArgumentException(ErrorMessageConst.ERROR_INVALID_EXCEED_MAX_LOTTO_COUNT);
        }
        return manualCount;
    }

    private static List<Lotto> readManualNumbers(LottoCount manualCount) {
        List<Lotto> manualLottos = new ArrayList<>();
        InputView.guideMessageToReadManualLottoNumbers();
        for (int i = 0; i < manualCount.getCount(); i++) {
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
