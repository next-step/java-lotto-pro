import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lotto.controller.LottoGameController;
import lotto.dto.LottoGameDTO;
import lotto.vo.Lottos;

public class Application {
    public static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Application().startLottoGame();
    }

    public void startLottoGame() throws IOException {
        LottoGameController lottoGameController = new LottoGameController();
        LottoGameDTO lottoGameDTO = purchaseLotto(lottoGameController);
        lottoGameDTO = generateLotto(lottoGameController, lottoGameDTO.getLottos());

    }

    private LottoGameDTO generateLotto(LottoGameController lottoGameController, Lottos lottos) {
        LottoGameDTO lottoGameDTO = lottoGameController.generateLottos(lottos);
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
        }while (isInputError);

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
