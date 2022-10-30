package lotto.controller;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCount;
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
        List<Lotto> lottos = generateLottos(lottoCount);

        ResultView.printPurchaseResult(lottos, lottoCount);
        ResultView.printResult(lottos, InputView.inputWinningLotto());
    }

    private static LottoCount getLottoCount() {
        int total = Money.from(InputView.inputPurchasePrice()).purchasableQuantity();
        int manual = InputView.inputManualLottoCount(total);
        return LottoCount.of(total, manual);
    }

    private List<Lotto> generateLottos(LottoCount lottoCount) {
        List<Lotto> manualLottos = InputView.inputManualLottos(lottoCount.getManual());
        return lottoGenerator.generate(lottoCount.getAuto(), manualLottos);
    }
}
