package lotto;

import lotto.controller.LottoGame;
import lotto.view.InputView;

public class LottoMain {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.inputPayAmount());
        lottoGame.checkLottoNumbers(InputView.inputLottoWinningNumbers());
    }
}