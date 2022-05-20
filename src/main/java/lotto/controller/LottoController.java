package lotto.controller;

import lotto.model.GameResult;
import lotto.model.LottoGame;
import lotto.model.RandomNumberGenerator;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;
    private static final int ZERO = 0;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startGame() {
        try {
            LottoGame game = new LottoGame();
            play(game);
        } catch (Exception e) {
            resultView.printErrorMessage(e.getMessage());
        }
    }

    private void play(LottoGame game) {
        game.insertMoney(inputView.insertMoney());

        int countOfManualLotto = game.purchaseManualLotto(inputView.inputManualLottoCount());
        while (!game.isSameSizeOfUserLotto(countOfManualLotto)) {
            game.inputManualLottoNumber(inputView.inputManualLottoNumber(game.isSameSizeOfUserLotto(ZERO)));
        }

        int countOfAutoLotto = game.purchaseAutoLotto(new RandomNumberGenerator());

        resultView.printGameStart(countOfManualLotto, countOfAutoLotto, game.getUserLotto());

        WinningLotto winningLotto = WinningLotto.of(inputView.inputWinnerNumbers(), inputView.inputBonusNumbers());
        GameResult gameResult = new GameResult(game, winningLotto);

        resultView.printGameResult(gameResult.gameResult());
        resultView.printBenefitResult(gameResult.calculateBenefit(), gameResult.referenceValue());
    }
}
