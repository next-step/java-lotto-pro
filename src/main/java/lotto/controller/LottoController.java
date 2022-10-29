package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.money.Money;
import lotto.domain.statistic.LottoStatistic;
import lotto.generator.LottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final LottoGenerator lottoGenerator;

    public LottoController(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void start() {
        Lottos lottos = lottoGenerator.generate(Money.from(InputView.inputPurchasePrice()));

        ResultView.printPurchaseResult(lottos);

        List<LottoNumber> winningNumbers =
                InputView.inputWinningNumbers()
                        .stream()
                        .map(LottoNumber::from)
                        .collect(Collectors.toList());

        ResultView.printResult(LottoStatistic.of(lottos, winningNumbers));
    }
}
