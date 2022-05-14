package Lotto;

import Lotto.utils.InputView;
import Lotto.utils.ResultView;

public class LottoGame {
    private Lottos lottos;
    private Lotto winLotto;

    public LottoGame() {
        lottos = new Lottos(InputView.inputMoney());
        winLotto = new Lotto(InputView.inputLastWinNumber());
    }

    public void calculation() {
        lottos.calculation(winLotto);
        ResultView.result(lottos.getResult());
    }
}
