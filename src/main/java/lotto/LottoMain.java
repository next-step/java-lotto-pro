package lotto;

import lotto.controller.LottoGame;
import lotto.view.InputView;

public class LottoMain {
    public static void main(String[] args) {
        LottoGame lottoGame = LottoGame.of(InputView.inputPayAmount());
        lottoGame.printLottoAmount();
        lottoGame.printLottos();
        lottoGame.start(InputView.inputLottoWinningNumbers(), InputView.inputBonusBall());
    }
}