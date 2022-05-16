package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.WinningLotto;
import lotto.lotto.ManualLottoes;
import lotto.money.Money;
import lotto.view.InputView;
import lotto.view.ResultView;
import java.util.List;

public class LottoMachine {

    private final LottoExchanger lottoExchanger;

    public LottoMachine() {
        this.lottoExchanger = new LottoExchanger();
    }

    public void run(InputView inputView, ResultView resultView) {
        final Money money = inputView.readMoney();
        final ManualLottoes manualLottoes = inputView.readManualLottoes();
        final List<Lotto> lottoes = lottoExchanger.exchange(money, manualLottoes);
        resultView.printLottoes(lottoes, manualLottoes.size());
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
