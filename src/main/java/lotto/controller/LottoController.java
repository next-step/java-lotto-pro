package lotto.controller;

import lotto.generator.LottoGenerator;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.statistic.LottoStatistic;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final LottoGenerator lottoGenerator;

    public LottoController(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void start() {
        Lottos lottos = lottoGenerator.generate(Money.from(InputView.inputPurchaseAmount()));

        ResultView.printPurchaseResult(lottos);

        LottoNumbers winningNumbers = LottoNumbers.fromBy(InputView.inputWinningNumbers());

        ResultView.printResult(LottoStatistic.of(lottos, winningNumbers));
    }
}
