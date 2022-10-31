package step4.controller;

import step4.model.Game;
import step4.model.LottoNumber;
import step4.model.LottoResult;
import step4.model.LottoWinningStatistics;
import step4.util.StringUtil;
import step4.view.InputView;
import step4.view.OutputView;

public class GameController {
    LottoResult winLottoResult;
    LottoNumber bonusLottoNumber;
    Game game;
    LottoWinningStatistics lottoWinningStatistics;

    public void startGame() {
        game = new Game(InputView.inputLottoBuyMoney());
        OutputView.printLottoBuyCount(game.getLottoBuyCount());
        game.startLottoGame();
        OutputView.printBuyLottoResult(game.getLottoResults());
        setWinLottoResult(InputView.inputWinnerLottoResult());
        setBonusNumber(InputView.inputLottoBonusNumber());
        setLottoWinningStatistics();
        OutputView.printLottoStatistics(lottoWinningStatistics.getLottoWinningStatistics()
                , lottoWinningStatistics.getTotalProfitPercent(game.getBuyMoney()));
    }

    private void setWinLottoResult(String inputLottoNumbers) {
        winLottoResult = new LottoResult(StringUtil.parseLottoText(inputLottoNumbers));
    }

    private void setBonusNumber(String inputLottoNumber) {
        bonusLottoNumber = new LottoNumber(inputLottoNumber);
    }

    private void setLottoWinningStatistics() {
        lottoWinningStatistics = new LottoWinningStatistics(game.getLottoResults(), winLottoResult, bonusLottoNumber);
    }
}
