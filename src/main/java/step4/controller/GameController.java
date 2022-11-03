package step4.controller;

import step4.model.*;
import step4.util.StringUtil;
import step4.view.InputView;
import step4.view.OutputView;

import java.util.stream.Collectors;

public class GameController {

    Game game;

    public void startGame() {
        Money money = new Money(InputView.inputLottoBuyMoney());
        LottoBuyCount manualBuyCount = new LottoBuyCount(InputView.inputBuyManualLottoCount());
        game = new Game(money, manualBuyCount);
        Lottos manualLottos = new Lottos(InputView.inputBuyManualLottos(manualBuyCount).stream().map(Lotto::new).collect(Collectors.toList()));

        OutputView.printLottoBuyCount(manualBuyCount, game.getLottoAutoBuyCount());
        Lottos lottos = game.startLottoGame();
        Lottos totalLottos = manualLottos.plus(lottos);
        OutputView.printBuyLottoResult(totalLottos);

        Lotto winLotto = new Lotto(StringUtil.parseLottoText(InputView.inputWinnerLottoResult()));
        LottoNumber bonusLottoNumber = LottoNumber.of(InputView.inputLottoBonusNumber());

        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(totalLottos, new WinningLotto(winLotto, bonusLottoNumber));
        OutputView.printLottoStatistics(lottoWinningStatistics.getLottoWinningStatistics()
                , lottoWinningStatistics.getTotalProfitPercent(game.getBuyMoney()));
    }

}
