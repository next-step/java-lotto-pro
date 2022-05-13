package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;
import static java.util.Objects.requireNonNull;

public class LottoMachine {

    private final LottoExchanger lottoExchanger;

    LottoMachine(LottoExchanger lottoExchanger) {
        this.lottoExchanger = requireNonNull(lottoExchanger, "lottoExchanger");
    }

    public void run(InputView inputView, ResultView resultView) {
        resultView.printLottoes(null);
        resultView.printResult(null, null);
    }
}
