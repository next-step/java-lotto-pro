package step4.controller;

import step4.model.*;
import step4.util.StringUtil;
import step4.view.InputView;
import step4.view.OutputView;

public class GameController {

    Game game;

    public void startGame() {
        game = new Game(InputView.inputLottoBuyMoney());
        OutputView.printLottoBuyCount(game.getLottoBuyCount());
        Lottos lottos = game.startLottoGame();
        OutputView.printBuyLottoResult(lottos);

        Lotto winLotto = new Lotto(StringUtil.parseLottoText(InputView.inputWinnerLottoResult()));
        LottoNumber bonusLottoNumber = LottoNumber.of(InputView.inputLottoBonusNumber());

        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(lottos, new WinningLotto(winLotto, bonusLottoNumber));
        OutputView.printLottoStatistics(lottoWinningStatistics.getLottoWinningStatistics()
                , lottoWinningStatistics.getTotalProfitPercent(game.getBuyMoney()));
    }

}
