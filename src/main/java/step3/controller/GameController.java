package step3.controller;

import step3.model.Game;
import step3.view.InputView;
import step3.view.OutputView;

public class GameController {
    public void startGame() {
        Game game = new Game(InputView.inputLottoBuyMoney());
        OutputView.printLottoBuyCount(game.getLottoBuyCount());
        OutputView.printBuyLottoResult(game);
        game.setWinLottoNumbers(InputView.inputWinnerLottoResult());
        OutputView.printLottoStatistics(game);
    }
}
