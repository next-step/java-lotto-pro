import java.io.IOException;
import lotto.constant.LottoGameMessage;
import lotto.controller.LottoGameController;
import lotto.dto.LottoGameDTO;
import lotto.utils.InputConsoleUtils;

public class Application {

    private static final LottoGameController lottoGameController = new LottoGameController();

    public static void main(String[] args) throws IOException {
        new Application().startLottoGame();
    }

    public void startLottoGame() throws IOException {
        LottoGameDTO lottoGameDTO = generateLottosByInputMoney();
        playLotto(lottoGameDTO);
    }

    private LottoGameDTO generateLottosByInputMoney() throws IOException {
        boolean isInputError;
        LottoGameDTO lottoGameDTO;
        do {
            String moneyWord = InputConsoleUtils.readLineForMessage(LottoGameMessage.INPUT_MONEY_MESSAGE);
            lottoGameDTO = lottoGameController.generateLottosByMoney(moneyWord);
            isInputError = lottoGameDTO.isInputError();
        } while (isInputError);
        return lottoGameDTO;
    }

    private void playLotto(LottoGameDTO requestLottoGameDTO) throws IOException {
        boolean isInputError;
        LottoGameDTO lottoGameDTO;
        do {
            String winningNumbersWord = InputConsoleUtils
                    .readLineForMessage(LottoGameMessage.INPUT_WINNING_NUMBERS_MESSAGE);
            lottoGameDTO = lottoGameController.resultWinningGame(requestLottoGameDTO.getLottos(), winningNumbersWord);
            isInputError = lottoGameDTO.isInputError();
        } while (isInputError);
    }


}
