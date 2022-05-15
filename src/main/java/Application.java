import java.io.IOException;
import lotto.constant.LottoInputMessage;
import lotto.controller.LottoGame;
import lotto.wrapper.LottosResultWrapper;
import lotto.model.LottoGameResult;
import lotto.model.Lottos;
import lotto.utils.InputConsoleUtils;
import lotto.view.ResultView;

public class Application {

    public static void main(String[] args) throws IOException {
        new Application().startLottoGame();
    }

    public void startLottoGame() throws IOException {
        playLotto(generateLottosByInputMoney());
    }

    private Lottos generateLottosByInputMoney() throws IOException {
        LottosResultWrapper lottosResultWrapper;
        do {
            String moneyWord = InputConsoleUtils.readLineForMessage(LottoInputMessage.MONEY_MESSAGE);
            lottosResultWrapper = fetchLottos(moneyWord);
        } while (lottosResultWrapper.isInputError());

        return lottosResultWrapper.getLottos();
    }

    private LottosResultWrapper fetchLottos(String moneyWord) {
        Lottos lottos = null;
        boolean isInputError = false;
        try {
            lottos = LottoGame.generateLottosByMoney(moneyWord);
            ResultView.printLottosView(lottos);
        } catch (IllegalArgumentException e) {
            ResultView.printConsole(e.getMessage());
            isInputError = true;
        }
        return new LottosResultWrapper(lottos, isInputError);
    }

    private void playLotto(Lottos lottos) throws IOException {
        LottosResultWrapper lottosResultWrapper;
        do {
            String winningNumbersWord = InputConsoleUtils.readLineForMessage(LottoInputMessage.WINNING_NUMBERS_MESSAGE);
            lottosResultWrapper = fetchResult(lottos, winningNumbersWord);
        } while (lottosResultWrapper.isInputError());
    }

    private LottosResultWrapper fetchResult(Lottos lottos, String winningNumbersWord) {
        boolean isInputError = false;
        try {
            LottoGameResult lottoGameResult = LottoGame.resultWinningGame(lottos, winningNumbersWord);
            ResultView.printFinalResultView(lottoGameResult, lottos);
        } catch (IllegalArgumentException e) {
            ResultView.printConsole(e.getMessage());
            isInputError = true;
        }
        return new LottosResultWrapper(lottos, isInputError);
    }
}
