package step4.controller;

import step4.model.Game;
import step4.model.LottoNumber;
import step4.model.LottoResult;
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
        List<LottoResult> lottoResults = game.startLottoGame();
        OutputView.printBuyLottoResult(lottoResults);
        
        LottoResult winLottoResult = new LottoResult(StringUtil.parseLottoText(InputView.inputWinnerLottoResult()));
        LottoNumber bonusLottoNumber = new LottoNumber(InputView.inputLottoBonusNumber());

        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(lottoResults, winLottoResult, bonusLottoNumber);
        OutputView.printLottoStatistics(lottoWinningStatistics.getLottoWinningStatistics()
                , lottoWinningStatistics.getTotalProfitPercent(game.getBuyMoney()));
    }

}
