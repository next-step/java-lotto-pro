package lotto.utils;

import lotto.domain.LottoStatistic;
import lotto.domain.TotalLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.io.IOException;

public class LottoGame {
    public void start() throws IOException {
        int amount = new InputView().printRequestAmount();
        Validation.isValidCount(amount);
        TotalLotto totalLotto = new TotalLotto();
        totalLotto.countAndLottos(amount);
        OutputView.printQuantity(totalLotto.getCount());
        totalLotto.getLottoList().printLottoList();
        winningLotto(totalLotto);
    }

    private void winningLotto(TotalLotto totalLotto) throws IOException {
        String winningLotto = new InputView().printRequestWinningLotto();
        totalLotto.winningLotto(winningLotto);
        LottoStatistic lottoStatistic = totalLotto.calculatorLottoStatic();
        OutputView.printLottoStatistic(lottoStatistic);
    }
}
