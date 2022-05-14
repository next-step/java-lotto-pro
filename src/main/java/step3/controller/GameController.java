package step3.controller;

import static step3.InputStatus.LOTTO;
import static step3.InputStatus.MONEY;
import static step3.LottoConstant.LOTTO_PRICE;

import step3.model.GameModel;
import step3.view.InputView;
import step3.view.OutputView;

public class GameController {

    private final GameModel gameModel;
    private final InputView inputView;
    private final OutputView outputView;

    private final boolean INPUT_IS_NOT_VALID = false;
    private final boolean INPUT_IS_VALID = true;

    public GameController(GameModel gameModel, InputView inputView, OutputView outputView) {
        this.gameModel = gameModel;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startLotto() {
        String money = "";
        boolean INPUT_CHECK_RESULT = INPUT_IS_NOT_VALID;

        while (INPUT_CHECK_RESULT == INPUT_IS_NOT_VALID) {
            money = inputView.getInput(MONEY);
            INPUT_CHECK_RESULT = createLottos(money);
        }
        INPUT_CHECK_RESULT = INPUT_IS_NOT_VALID;
        while (INPUT_CHECK_RESULT == INPUT_IS_NOT_VALID) {
            INPUT_CHECK_RESULT = checkWinLotto(inputView.getInput(LOTTO), money);
        }
    }

    private boolean checkWinLotto(String lottoSource, String money) {
        try {
            gameModel.validInput(lottoSource, LOTTO);
            outputView.printOutput(gameModel.checkWin(lottoSource), Integer.parseInt(money) / LOTTO_PRICE);
        } catch (IllegalArgumentException e) {
            return INPUT_IS_NOT_VALID;
        }
        return INPUT_IS_VALID;
    }


    private boolean createLottos(String money) {
        try {
            gameModel.validInput(money, MONEY);
            gameModel.buyTicket(Integer.parseInt(money));
            outputView.printLottoInfo(gameModel.getLottoNumbers());
        } catch (IllegalArgumentException e) {
            return INPUT_IS_NOT_VALID;
        }
        return INPUT_IS_VALID;
    }
}
