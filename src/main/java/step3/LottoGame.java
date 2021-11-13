package step3;

import step3.component.GameStatusChangeable;
import step3.component.LottoGeneratorable;
import step3.component.LottoShuffleable;
import step3.domain.Lotto;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.view.ConsoleInputView;
import step3.view.ConsoleOutputView;
import step3.view.LottoResult;

public class LottoGame {

    private final LottoGeneratorable lottoGeneratorable;
    private final LottoShuffleable lottoShuffleable;
    private final ConsoleInputView consoleInputView;
    private final ConsoleOutputView consoleOutputView;
    private final GameStatusChangeable gameStatusManager;

    public LottoGame(final LottoGeneratorable lottoGeneratorable, final LottoShuffleable lottoShuffleable,
        final GameStatusChangeable gameStatusManager, final ConsoleInputView consoleInputView,
        final ConsoleOutputView consoleOutputView) {
        this.lottoGeneratorable = lottoGeneratorable;
        this.lottoShuffleable = lottoShuffleable;
        this.gameStatusManager = gameStatusManager;
        this.consoleInputView = consoleInputView;
        this.consoleOutputView = consoleOutputView;

        this.gameStatusManager.start();
    }

    public void start() {
        while (gameStatusManager.isStart()) {
            runLotto();
        }
    }

    private void runLotto() {
        try {
            final Money money = prepareMoney();
            final LottoTicket lottoTicket = prepareLottoTicket(money, lottoShuffleable);

            final Lotto winningLotto = prepareWinningLotto();
            consoleOutputView.lineSeparator();

            final String result = LottoResult.checkout(winningLotto, lottoTicket, money);
            consoleOutputView.print(result);

            gameStatusManager.end();
        } catch (Exception e) {
            consoleOutputView.error(e);
        }
    }

    private Money prepareMoney() {
        consoleOutputView.print("구입금액을 입력해 주세요.");
        final Money money = consoleInputView.inputMoney();

        consoleOutputView.printMoney(money);

        return money;
    }

    private LottoTicket prepareLottoTicket(final Money money, final LottoShuffleable lottoShuffleable) {
        final LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.publish(money, lottoShuffleable);

        consoleOutputView.printLottoTicket(lottoTicket);
        consoleOutputView.lineSeparator();

        return lottoTicket;
    }

    private Lotto prepareWinningLotto() {
        consoleOutputView.print("지난 주 당첨 번호를 입력해 주세요.");

        return consoleInputView.inputWinningLotto(lottoGeneratorable);
    }
}
