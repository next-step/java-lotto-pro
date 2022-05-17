package lotto.controller;

import lotto.model.LottoGame;
import lotto.model.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startGame() {
        LottoGame game = new LottoGame();
        play(game);
    }

    private void play(LottoGame game) {
        insertMoney(game);

        inputWinnerNumbers(game);
        inputBonusNumbers(game);

        printGameResult(game);
    }

    private void insertMoney(LottoGame game) {
        String amount;
        do {
            amount = inputView.insertMoney();
        } while (!game.insertMoney(amount));

        int countOfLotto = game.buyLottoTicket(new RandomNumberGenerator());
        resultView.printGameStart(countOfLotto, game.getUserLotto());
    }

    private void inputWinnerNumbers(LottoGame game) {
        String winnerNumbers;
        do {
            winnerNumbers = inputView.inputWinnerNumbers();
        } while (!game.winnersNumber(winnerNumbers));
    }

    private void inputBonusNumbers(LottoGame game) {
        String bonusNumber;
        do {
            bonusNumber = inputView.inputBonusNumbers();
        } while (!game.bonusNumber(bonusNumber));
    }

    private void printGameResult(LottoGame game) {
        resultView.printGameResult(game.gameResult());
        resultView.printBenefitResult(game.benefitResult(), game.referenceValue());
    }
}
