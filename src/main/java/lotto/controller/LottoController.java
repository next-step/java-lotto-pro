package lotto.controller;

import lotto.model.lotto.LottoGenerator;
import lotto.model.lotto.LottoNumbers;
import lotto.model.lotto.Lottos;
import lotto.model.money.Money;
import lotto.model.statistic.LottoStatistic;
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
