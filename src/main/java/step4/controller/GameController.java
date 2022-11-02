package step4.controller;

import step4.model.Game;
import step4.model.Lotto;
import step4.model.LottoNumber;
import step4.model.LottoWinningStatistics;
import step4.util.StringUtil;
import step4.view.InputView;
import step4.view.OutputView;

import java.util.List;

public class GameController {

    Game game;

    public void startGame() {
        game = new Game(InputView.inputLottoBuyMoney());
        OutputView.printLottoBuyCount(game.getLottoBuyCount());
        List<Lotto> lottos = game.startLottoGame();
        OutputView.printBuyLottoResult(lottos);

        Lotto winLotto = new Lotto(StringUtil.parseLottoText(InputView.inputWinnerLottoResult()));
        LottoNumber bonusLottoNumber = new LottoNumber(InputView.inputLottoBonusNumber());

        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(lottos, winLotto, bonusLottoNumber);
        OutputView.printLottoStatistics(lottoWinningStatistics.getLottoWinningStatistics()
                , lottoWinningStatistics.getTotalProfitPercent(game.getBuyMoney()));
    }

}
