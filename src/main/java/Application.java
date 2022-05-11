import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lotto.controller.LottoGameController;
import lotto.dto.LottoGameResponseDTO;

public class Application {
    public static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Application().startLottoGame();
    }

    public void startLottoGame() throws IOException {
        LottoGameController lottoGameController = new LottoGameController();
        LottoGameResponseDTO lottoGameResponseDTO = purchaseLotto(lottoGameController);
    }

    private LottoGameResponseDTO purchaseLotto(LottoGameController lottoGameController) throws IOException {
        boolean isInputError;
        LottoGameResponseDTO lottoGameResponseDTO;
        do {
            String moneyWord = getInputMoney(lottoGameController);
            lottoGameResponseDTO = lottoGameController.purchaseLotto(moneyWord);
            isInputError = lottoGameResponseDTO.isInputError();
            printMessage(lottoGameResponseDTO);
        }while (isInputError);

        return lottoGameResponseDTO;
    }

    private String getInputMoney(LottoGameController lottoGameController) throws IOException {
        LottoGameResponseDTO lottoGameResponseDTO = lottoGameController.inputMoney();
        printMessage(lottoGameResponseDTO);
        String moneyWord = BUFFERED_READER.readLine();
        return moneyWord;
    }

    private void printMessage(LottoGameResponseDTO lottoGameResponseDTO) {
        System.out.println(lottoGameResponseDTO.getView());
    }
}
