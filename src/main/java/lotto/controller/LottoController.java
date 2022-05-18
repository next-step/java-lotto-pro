package lotto.controller;

import lotto.model.LottoGame;
import lotto.model.RandomNumberGenerator;
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
        LottoGame game = new LottoGame();
        play(game);
    }

    private void play(LottoGame game) {
        insertMoney(game);

        purchaseLotto(game);

        inputWinnerNumbers(game);
        inputBonusNumbers(game);

        printGameResult(game);
    }

    private void insertMoney(LottoGame game) {
        String amount;
        do {
            amount = inputView.insertMoney();
        } while (!game.insertMoney(amount));
    }

    private void purchaseLotto(LottoGame game) {
        int countOfManualLotto = inputManualLottoCount(game);

        while (countOfManualLotto != game.getUserLotto().size()) {
            game.inputManualLottoNumber(inputView.inputManualLottoNumber(game.getUserLotto().size() == ZERO));
        }

        int countOfAutoLotto = game.purchaseAutoLotto(new RandomNumberGenerator());

        resultView.printGameStart(countOfManualLotto, countOfAutoLotto, game.getUserLotto());
    }

    private int inputManualLottoCount(LottoGame game) {
        String countOfManualLotto;
        do {
            countOfManualLotto = inputView.inputManualLottoCount();
        } while (!game.purchaseManualLotto(countOfManualLotto));

        return Integer.parseInt(countOfManualLotto);
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
