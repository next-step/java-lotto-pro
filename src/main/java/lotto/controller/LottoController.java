package lotto.controller;

import java.util.List;
import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.Money;
import lotto.generator.LottoGenerator;
import lotto.generator.LottoNumberGenerator;
import lotto.generator.LottoNumberGeneratorStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final LottoGenerator lottoGenerator;

    public LottoController(LottoNumberGeneratorStrategy numberGeneratorStrategy) {
        this.lottoGenerator = LottoGenerator.from(LottoNumberGenerator.from(numberGeneratorStrategy));
    }

    public void start() {
        LottoCount lottoCount = getLottoCount();
        Lottos lottos = generateLottos(lottoCount);

        ResultView.printPurchaseResult(lottos, lottoCount);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);

        ResultView.printResult(lottos, WinningLotto.of(winningNumbers, bonusNumber));
    }

    private static LottoCount getLottoCount() {
        int total = Money.from(InputView.inputPurchasePrice()).purchasableQuantity();
        int manual = InputView.inputManualLottoCount(total);
        return LottoCount.of(total, manual);
    }

    private Lottos generateLottos(LottoCount lottoCount) {
        Lottos manualLottos = Lottos.fromBy(InputView.inputManualLottos(lottoCount.getManual()));
        Lottos autoCreatedLottos = lottoGenerator.generate(lottoCount.getAuto());
        return manualLottos.add(autoCreatedLottos);
    }
}
