package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoGenerator;
import lotto.lotto.WinningLotto;
import lotto.money.Money;
import lotto.view.InputView;
import lotto.view.ResultView;
import java.util.List;
import static java.util.Objects.requireNonNull;

public class LottoMachine {

    private final LottoExchanger lottoExchanger;

    public LottoMachine(LottoGenerator lottoGenerator) {
        this.lottoExchanger = new LottoExchanger(requireNonNull(lottoGenerator, "lottoGenerator"));
    }

    LottoMachine() {
        this(LottoGenerator.random());
    }

    public void run(InputView inputView, ResultView resultView) {
        final Money money = inputView.readMoney();
        final List<Lotto> lottoes = lottoExchanger.exchange(money, null);
        resultView.printLottoes(lottoes, -1);
        runAnalyze(inputView, resultView, lottoes);
    }

    private void runAnalyze(InputView inputView, ResultView resultView, List<Lotto> lottoes) {
        final WinningLotto previousWinningLotto = inputView.readPreviousWinningLotto();
        final LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(previousWinningLotto);
        final WinningResult winningResult = lottoAnalyzer.analyze(lottoes);
        resultView.printResult(winningResult, sumTotalMoney(lottoes));
    }

    private Money sumTotalMoney(List<Lotto> lottoes) {
        return lottoes.stream()
                      .map(Lotto::price)
                      .reduce(Money.of(0), Money::add);
    }
}
