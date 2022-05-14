package lotto.controller;

import static lotto.constants.LottoGuideMessage.LAST_WINNING_INPUT;

import generator.LottoNumberGenerator;
import generator.NumberGenerator;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningStatistics;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

public class LottoController {
    private final LottoInputView lottoInputView;
    private final LottoResultView resultView;
    private final NumberGenerator numberGenerator;

    public LottoController() {
        this.lottoInputView = new LottoInputView();
        this.resultView = new LottoResultView();
        this.numberGenerator = new LottoNumberGenerator();
    }

    public void play() {
        Money money = lottoInputView.inputMoney();
        Lottos lottos = purchaseLottos(money);
        LottoNumbers lastWinningLottoNumbers = LottoNumbers.generateBy(inputLastWinningLottoNumbers());

        WinningStatistics winningStatistics = WinningStatistics.of(lottos, lastWinningLottoNumbers, money);
        winningStatistics.statistics();

        resultView.printWinningStatistics(winningStatistics);
    }

    private List<Integer> inputLastWinningLottoNumbers() {
        System.out.println(LAST_WINNING_INPUT);
        return lottoInputView.inputLottoNumbers(LAST_WINNING_INPUT);
    }

    private Lottos purchaseLottos(Money money) {
        LottoCount lottoCount = LottoCount.calculateBy(money);
        Lottos lottos = Lottos.from(generateAutoLottoNumbers(lottoCount));
        resultView.printLottos(lottos);

        return lottos;
    }

    private List<Lotto> generateAutoLottoNumbers(LottoCount lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount.getCount(); i++) {
            LottoNumbers lottoNumbers = LottoNumbers.generateBy(this.numberGenerator);
            lottos.add(Lotto.from(lottoNumbers));
        }
        return lottos;
    }
}
