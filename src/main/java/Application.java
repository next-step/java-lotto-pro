import java.io.IOException;
import lotto.constant.LottoGameMessage;
import lotto.controller.LottoGameController;
import lotto.dto.LottoGameDTO;
import lotto.view.InputConsole;

public class Application {

    public static void main(String[] args) throws IOException {
        new Application().startLottoGame();
    }

    public void startLottoGame() throws IOException {
        LottoGameController lottoGameController = new LottoGameController();
        LottoGameDTO lottoGameDTO = generateLottos(lottoGameController);
        playLotto(lottoGameController, lottoGameDTO);
    }

    private void playLotto(LottoGameController lottoGameController, LottoGameDTO requestLottoGameDTO)
            throws IOException {
        boolean isInputError;
        LottoGameDTO lottoGameDTO;
        do {
            String winningNumbersWord = InputConsole.readStringForMessage(LottoGameMessage.INPUT_WINNING_NUMBERS_MESSAGE);
            lottoGameDTO = lottoGameController.playLottoGame(requestLottoGameDTO, winningNumbersWord);
            isInputError = lottoGameDTO.isInputError();
        } while (isInputError);
    }

    private LottoGameDTO generateLottos(LottoGameController lottoGameController) throws IOException {
        boolean isInputError;
        LottoGameDTO lottoGameDTO;
        do {
            String moneyWord = InputConsole.readStringForMessage(LottoGameMessage.INPUT_MONEY_MESSAGE);
            lottoGameDTO = lottoGameController.generateLottoByMoney(moneyWord);
            isInputError = lottoGameDTO.isInputError();
        } while (isInputError);

        return lottoGameDTO;
    }

}
