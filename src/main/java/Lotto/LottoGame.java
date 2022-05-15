package Lotto;

import Lotto.utils.InputView;
import Lotto.utils.ResultView;

public class LottoGame {
    private Lottos lottos;
    private Lotto winLotto;

    public LottoGame() {
        lottos = new Lottos(InputView.inputMoney());
        ResultView.printPurchaseLottos(lottos);
        winLotto = new Lotto(InputView.inputLastWinNumber());
    }

    public void calculation() {
        LottoResult result = lottos.calculation(winLotto);
        ResultView.result(result);
    }
}
