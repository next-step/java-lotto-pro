import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lotto.controller.LottoGameController;
import lotto.dto.LottoGameDTO;

public class Application {
    public static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Application().startLottoGame();
    }

    public void startLottoGame() throws IOException {
        LottoGameController lottoGameController = new LottoGameController();
        LottoGameDTO lottoGameDTO = purchaseLotto(lottoGameController);
        lottoGameDTO = generateLotto(lottoGameController, lottoGameDTO);
        playLotto(lottoGameController, lottoGameDTO);
    }

    private void playLotto(LottoGameController lottoGameController, LottoGameDTO requestLottoGameDTO)
            throws IOException {
        boolean isInputError;
        LottoGameDTO lottoGameDTO;
        do {
            String winningNumbersWord = getInputWinningNumbers(lottoGameController);
            lottoGameDTO = lottoGameController.playLottoGame(requestLottoGameDTO, winningNumbersWord);
            printMessage(lottoGameDTO);
            isInputError = lottoGameDTO.isInputError();
        } while (isInputError);
    }

    private String getInputWinningNumbers(LottoGameController lottoGameController) throws IOException {
        LottoGameDTO lottoGameDTO;
        lottoGameDTO = lottoGameController.inputWinningNumbers();
        printMessage(lottoGameDTO);
        return BUFFERED_READER.readLine();
    }

    private LottoGameDTO generateLotto(LottoGameController lottoGameController, LottoGameDTO requestLottoGameDTO) {
        LottoGameDTO lottoGameDTO = lottoGameController.generateLottos(requestLottoGameDTO);
        printMessage(lottoGameDTO);
        return lottoGameDTO;
    }

    private LottoGameDTO purchaseLotto(LottoGameController lottoGameController) throws IOException {
        boolean isInputError;
        LottoGameDTO lottoGameDTO;
        do {
            String moneyWord = getInputMoney(lottoGameController);
            lottoGameDTO = lottoGameController.purchaseLotto(moneyWord);
            isInputError = lottoGameDTO.isInputError();
            printMessage(lottoGameDTO);
        } while (isInputError);

        return lottoGameDTO;
    }

    private String getInputMoney(LottoGameController lottoGameController) throws IOException {
        LottoGameDTO lottoGameDTO = lottoGameController.inputMoney();
        printMessage(lottoGameDTO);
        String moneyWord = BUFFERED_READER.readLine();
        return moneyWord;
    }

    private void printMessage(LottoGameDTO lottoGameDTO) {
        System.out.println(lottoGameDTO.getView());
    }
}
