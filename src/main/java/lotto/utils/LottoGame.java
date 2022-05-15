package lotto.utils;

import lotto.domain.TotalLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.io.IOException;

public class LottoGame {
    public void start() throws IOException, IllegalAccessException {
        String amount = new InputView().printStart();
        TotalLotto totalLotto = new TotalLotto();
        totalLotto.countAndLottos(amount);
        OutputView.printQuantity(totalLotto.getCount());
        totalLotto.getLottoList().printLottoList();
    }
}
