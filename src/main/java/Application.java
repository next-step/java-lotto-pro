import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoInputMessage;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.LottoPaper;
import lotto.model.LottoSelfCount;
import lotto.model.LottoStore;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.model.generator.LottoGenerator;
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
        LottoStore lottoStore = createLottoStore();
        LottoPaper lottoPaper = lottoStore.issueLottoPaper();
        LottoGenerator lottoGenerator = new LottoGeneratorRandomImpl();
        Lottos lottos = lottoGenerator.generateLottos(createSelfLottos(lottoPaper), lottoPaper);
        ResultView.printLottosView(lottos, lottoPaper);

        WinningLotto winningLotto = createWinningLotto();
        LottoGameResult lottoGameResult = winningLotto.compareLottos(lottos);
        ResultView.printFinalResultView(lottoGameResult, lottos);
    }

    private Lottos createSelfLottos(LottoPaper LottoPaper) throws IOException {
        try {
            InputConsoleUtils.printMessage(LottoInputMessage.SELF_NUMBERS_MESSAGE);
            return inputSelfLottos(LottoPaper);
        } catch (IllegalArgumentException e) {
            ResultView.printConsole(e.getMessage());
            return createSelfLottos(LottoPaper);
        }
    }

    private Lottos inputSelfLottos(LottoPaper lottoPaper) throws IOException {
        List<Lotto> lottos = new ArrayList<>();
        for (int lottoCount = 0; lottoCount < lottoPaper.getSelfCount(); lottoCount++) {
            String selfNumbersWord = InputConsoleUtils.readLine();
            List<String> selfNumberWords = InputStringUtils.nonSpaceSplit(selfNumbersWord, DELIMITER_COMMA);
            lottos.add(new Lotto(new LottoNumbers(selfNumberWords)));
        }
        return new Lottos(lottos);
    }

    private LottoStore createLottoStore() throws IOException {
        try {
            Money money = inputMoney();
            LottoSelfCount lottoSelfCount = inputLottoCount();
            return new LottoStore(money, lottoSelfCount);
        } catch (IllegalArgumentException e) {
            ResultView.printConsole(e.getMessage());
            return createLottoStore();
        }
    }

    private LottoSelfCount inputLottoCount() throws IOException {
        try {
            String selfCountWord = InputConsoleUtils.readLineForMessage(LottoInputMessage.SELF_COUNT_MESSAGE);
            return new LottoSelfCount(selfCountWord);
        } catch (IllegalArgumentException e) {
            ResultView.printConsole(e.getMessage());
            return inputLottoCount();
        }
    }

    private Money inputMoney() throws IOException {
        try {
            String moneyWord = InputConsoleUtils.readLineForMessage(LottoInputMessage.MONEY_MESSAGE);
            return new Money(moneyWord);
        } catch (IllegalArgumentException e) {
            ResultView.printConsole(e.getMessage());
            return inputMoney();
        }
    }

    private WinningLotto createWinningLotto() throws IOException {
        try {
            LottoNumbers winningLottoNumbers = inputLottoNumbers(LottoInputMessage.WINNING_NUMBERS_MESSAGE);
            LottoNumber bonusNumber = inputLottoNumber(LottoInputMessage.BONUS_NUMBER_MESSAGE);
            return new WinningLotto(winningLottoNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            return createWinningLotto();
        }
    }

    private LottoNumbers inputLottoNumbers(String message) throws IOException {
        try {
            String winningNumberWords = InputConsoleUtils.readLineForMessage(message);
            List<String> winningNumbers = InputStringUtils.nonSpaceSplit(winningNumberWords, DELIMITER_COMMA);
            return new LottoNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            ResultView.printConsole(e.getMessage());
            return inputLottoNumbers(message);
        }
    }

    private LottoNumber inputLottoNumber(String message) throws IOException {
        try {
            String numberWord = InputConsoleUtils.readLineForMessage(message);
            return new LottoNumber(numberWord);
        } catch (IllegalArgumentException e) {
            ResultView.printConsole(e.getMessage());
            return inputLottoNumber(message);
        }
    }
}
