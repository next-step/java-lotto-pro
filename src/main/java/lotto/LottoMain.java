package lotto;

import lotto.view.InputView;

public class LottoMain {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.inputPayAmount());
        lottoGame.findWinner(InputView.inputLottoWinnerNumbers());
        lottoGame.printResult();
    }
}