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
        LottoBuyCount lottoManualBuyCount = new LottoBuyCount(InputView.inputBuyManualLottoCount());
        game = new Game(money, lottoManualBuyCount);
        Lottos manualLottos = game.startLottoGame((new LottoManualGenerator(InputView.inputBuyManualLottos(lottoManualBuyCount), lottoManualBuyCount)));
        Lottos autoLottos = game.startLottoGame(new LottoAutoGenerator(game.getLottoAutoBuyCount(lottoManualBuyCount)));

        OutputView.printLottoBuyCount(lottoManualBuyCount, game.getLottoAutoBuyCount(lottoManualBuyCount));
        Lottos totalLottos = manualLottos.plus(autoLottos);
        OutputView.printBuyLottoResult(totalLottos);

        Lotto winLotto = new Lotto(StringUtil.parseLottoText(InputView.inputWinnerLottoResult()));
        LottoNumber bonusLottoNumber = LottoNumber.of(InputView.inputLottoBonusNumber());

        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(totalLottos, new WinningLotto(winLotto, bonusLottoNumber));
        OutputView.printLottoStatistics(lottoWinningStatistics.getLottoWinningStatistics()
                , lottoWinningStatistics.getTotalProfitPercent(money));
    }
}
