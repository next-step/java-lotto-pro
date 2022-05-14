import java.io.IOException;
import lotto.constant.LottoGameMessage;
import lotto.controller.LottoGameController;
import lotto.dto.LottoGameDTO;
import lotto.view.InputConsole;

public class Application {

    private static final LottoGameController lottoGameController = new LottoGameController();

    public static void main(String[] args) throws IOException {
        new Application().startLottoGame();
    }

    public void startLottoGame() throws IOException {
        LottoGameDTO lottoGameDTO = generateLottosByInputMoney();
        playLotto(lottoGameDTO);
    }

    private void playLotto(LottoGameDTO requestLottoGameDTO) throws IOException {
        boolean isInputError;
        LottoGameDTO lottoGameDTO;
        do {
            String winningNumbersWord = InputConsole.readLineForMessage(LottoGameMessage.INPUT_WINNING_NUMBERS_MESSAGE);
            lottoGameDTO = lottoGameController.playLottoGame(requestLottoGameDTO, winningNumbersWord);
            isInputError = lottoGameDTO.isInputError();
        } while (isInputError);
    }

    private LottoGameDTO generateLottosByInputMoney() throws IOException {
        boolean isInputError;
        LottoGameDTO lottoGameDTO;
        do {
            String moneyWord = InputConsole.readLineForMessage(LottoGameMessage.INPUT_MONEY_MESSAGE);
            lottoGameDTO = lottoGameController.generateLottos(moneyWord);
            isInputError = lottoGameDTO.isInputError();
        } while (isInputError);
        return lottoGameDTO;
    }

}
