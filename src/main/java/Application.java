import java.io.IOException;
import java.util.List;
import lotto.constant.LottoInputMessage;
import lotto.controller.LottoGame;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.model.generator.LottoGeneratorRandomImpl;
import lotto.utils.InputStringUtils;
import lotto.model.LottoGameResult;
import lotto.model.Lottos;
import lotto.utils.InputConsoleUtils;
import lotto.view.ResultView;

public class Application {

    private static final String DELIMITER_COMMA = ",";

    public static void main(String[] args) throws IOException {
        new Application().startLottoGame();
    }

    public void startLottoGame() throws IOException {
        Money money = inputMoney();
        Lottos lottos = LottoGame.generateLottosByGenerator(money, new LottoGeneratorRandomImpl());
        ResultView.printLottosView(lottos);

        WinningLotto winningLotto = createWinningLotto();
        LottoGameResult lottoGameResult = LottoGame.resultWinningGame(winningLotto, lottos);
        ResultView.printFinalResultView(lottoGameResult, lottos);
    }

    private Money inputMoney() throws IOException {
        while (true) {
            try {
                String moneyWord = InputConsoleUtils.readLineForMessage(LottoInputMessage.MONEY_MESSAGE);
                return new Money(moneyWord);
            } catch (IllegalArgumentException e) {
                ResultView.printConsole(e.getMessage());
            }
        }
    }

    private WinningLotto createWinningLotto() throws IOException {
        LottoNumbers winningLottoNumbers = inputLottoNumbers(LottoInputMessage.WINNING_NUMBERS_MESSAGE);
        LottoNumber bonusNumber = inputLottoNumber(LottoInputMessage.BONUS_NUMBER_MESSAGE);
        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    private LottoNumbers inputLottoNumbers(String message) throws IOException {
        while (true) {
            try {
                String winningNumberWords = InputConsoleUtils.readLineForMessage(message);
                List<String> winningNumbers = InputStringUtils.nonSpaceSplit(winningNumberWords, DELIMITER_COMMA);
                return new LottoNumbers(winningNumbers);
            } catch (IllegalArgumentException e) {
                ResultView.printConsole(e.getMessage());
            }
        }
    }

    private LottoNumber inputLottoNumber(String message) throws IOException {
        while (true) {
            try {
                String numberWord = InputConsoleUtils.readLineForMessage(message);
                return new LottoNumber(numberWord);
            } catch (IllegalArgumentException e) {
                ResultView.printConsole(e.getMessage());
            }
        }
    }
}
