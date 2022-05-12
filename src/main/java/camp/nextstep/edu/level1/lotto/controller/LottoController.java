package camp.nextstep.edu.level1.lotto.controller;

import camp.nextstep.edu.level1.lotto.lotto.Lotto;
import camp.nextstep.edu.level1.lotto.lotto.LottoResult;
import camp.nextstep.edu.view.InputView;
import camp.nextstep.edu.view.OutputView;

public class LottoController {

    private LottoController() {}

    public static void executeLotto() {
        Lotto lotto = InputView.enterLottoValue();
        LottoResult lottoResult = InputView.enterLottoWinningNumbers(lotto);
        OutputView.showLottoResultStatistics(lotto, lottoResult);
    }
}
