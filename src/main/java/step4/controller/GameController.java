package step4.controller;

import step4.model.*;
import step4.model.generator.LottoAutoGenerator;
import step4.model.generator.LottoManualGenerator;
import step4.util.StringUtil;
import step4.view.InputView;
import step4.view.OutputView;

public class GameController {

    Game game;

    public void startGame() {
        Money money = new Money(InputView.inputLottoBuyMoney());
        LottoBuyCount lottoTotalCount = new LottoBuyCount(money);
        LottoBuyCount lottoManualBuyCount = new LottoBuyCount(InputView.inputBuyManualLottoCount());
        LottoBuyCount lottoAutoBuyCount = lottoTotalCount.minus(lottoManualBuyCount);

        game = new Game();

        game.startLottoGame(
                new LottoManualGenerator(InputView.inputBuyManualLottos(lottoManualBuyCount), lottoManualBuyCount)
        );
        game.startLottoGame(new LottoAutoGenerator(lottoAutoBuyCount));

        OutputView.printLottoBuyCount(lottoManualBuyCount, lottoAutoBuyCount);
        OutputView.printBuyLottoResult(game.getTotalLottos());

        Lotto winLotto = new Lotto(StringUtil.parseLottoText(InputView.inputWinnerLottoResult()));
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(InputView.inputLottoBonusNumber());

        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(
                game.getTotalLottos(), new WinningLotto(winLotto, bonusLottoNumber)
        );
        OutputView.printLottoStatistics(lottoWinningStatistics.getLottoWinningStatistics()
                , lottoWinningStatistics.getTotalProfitPercent(money));
    }
}
