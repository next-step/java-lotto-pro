package lotto.controller;

import lotto.constant.ErrorMessageConst;
import lotto.domain.*;
import lotto.generator.LottosGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static final int INT_ZERO = 0;

    public static void simulateLotto(){
        Money money = readMoney();
        LottoCount manualCount = readManualCount(money.maxLottoCount());
        Lottos lottos = LottosGenerator.purchaseManualAndAutoLottos(money, readManualNumbers(manualCount));
        OutputView.printPurchasedLottos(lottos, manualCount);

        Lotto winningLotto = readWinningNumbers();
        LottoNumber bonusNumber = LottoNumber.from(InputView.readBonusNumber());
        LottoResult result = LottoResult.of(lottos, winningLotto, bonusNumber);
        OutputView.printLottoResult(result, money.calculateProfit(result.winningPrize()));
    }

    private static Money readMoney() {
        Money money = Money.from(InputView.readMoney());
        if (money.maxLottoCount().isLessThan(LottoCount.from(INT_ZERO))) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessageConst.ERROR_INVALID_MONEY_CANNOT_BUY_LOTTO, Money.LOTTO_PRICE)
            );
        }
        return money;
    }

    private static LottoCount readManualCount(LottoCount maxCount) {
        LottoCount manualCount = LottoCount.from(InputView.readManualLottosCount());
        if (manualCount.isGreaterThan(maxCount)) {
            throw new IllegalArgumentException(ErrorMessageConst.ERROR_INVALID_LOTTO_COUNT_EXCEED_MAX);
        }
        return manualCount;
    }

    private static List<Lotto> readManualNumbers(LottoCount manualCount) {
        List<Lotto> manualLottos = new ArrayList<>();
        InputView.guideMessageToReadManualLottoNumbers();
        for (int i = 0; i < manualCount.getCount(); i++) {
            manualLottos.add(Lotto.from(InputView.readSimpleLottoNumbers()));
        }
        return manualLottos;
    }

    private static Lotto readWinningNumbers(){
        return Lotto.from(InputView.readLottoWinningNumber());
    }
}
