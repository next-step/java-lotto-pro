package lotto.utils;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {
    public void start() {
        ManualLotto manualLotto = generateManualLotto();
        Lottos lottos = LottoFactory.generateTotalLottos(manualLotto);

        LottoGameDto totalLotto = LottoGameDto.of(manualLotto, lottos);
        OutputView.printQuantity(totalLotto);

        Lotto lotto = LottoFactory.manualGenerator(InputView.getWinningLottoPrint());
        LottoNumber lottoNumber = LottoNumber.from(InputView.getBonusNumberPrint());
        WinningLotto winningLotto = WinningLotto.of(lotto, lottoNumber);
        LottoScore lottoScore = lottos.getLottoScore(winningLotto);

        OutputView.printLottoStatistic(lottoScore);
        OutputView.printProfit(lottoScore, manualLotto.getMoney());
    }

    private ManualLotto generateManualLotto() {
        int amount = InputView.getAmountPrint();
        int manualCount = InputView.getManualCountPrint();
        Money money = Money.of(amount, manualCount);
        List<String> inputManualLottoNumbers = InputView.getManualLottoNumbers(manualCount);
        return ManualLotto.of(money, inputManualLottoNumbers);
    }
}
