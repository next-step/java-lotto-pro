import java.io.IOException;
import lotto.constant.LottoInputMessage;
import lotto.controller.LottoGame;
import lotto.dto.LottoGameDTO;
import lotto.utils.InputConsoleUtils;

public class Application {

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
            String moneyWord = InputConsoleUtils.readLineForMessage(LottoInputMessage.MONEY_MESSAGE);
            lottoGameDTO = LottoGame.generateLottosByMoney(moneyWord);
            isInputError = lottoGameDTO.isInputError();
        } while (isInputError);
        return lottoGameDTO;
    }

    private void playLotto(LottoGameDTO requestLottoGameDTO) throws IOException {
        boolean isInputError;
        LottoGameDTO lottoGameDTO;
        do {
            String winningNumbersWord = InputConsoleUtils.readLineForMessage(LottoInputMessage.WINNING_NUMBERS_MESSAGE);
            lottoGameDTO = LottoGame.resultWinningGame(requestLottoGameDTO.getLottos(), winningNumbersWord);
            isInputError = lottoGameDTO.isInputError();
        } while (isInputError);
    }


}
