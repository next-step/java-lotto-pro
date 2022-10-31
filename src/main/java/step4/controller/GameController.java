package step4.controller;

import step4.model.Game;
import step4.view.InputView;
import step4.view.OutputView;

public class GameController {
    public void startGame() {
        Game game = new Game(InputView.inputLottoBuyMoney());
        OutputView.printLottoBuyCount(game.getLottoBuyCount());
        game.startLottoGame();
        OutputView.printBuyLottoResult(game.getLottoResults());
        game.setWinLottoResult(InputView.inputWinnerLottoResult());
        game.startLottoWinningStatistics();
        OutputView.printLottoStatistics(game.getLottoWinningStatistics().getLottoWinningStatistics(), game.getProfitPercent());
    }
}
