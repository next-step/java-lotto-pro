package lotto;

import java.text.MessageFormat;
import lotto.component.GameStatusChangeable;
import lotto.component.LottoGeneratorable;
import lotto.component.LottoShuffleable;
import lotto.domain.BonusBall;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.LottoResult;
import util.NumberUtils;

public class LottoGame {

    private final LottoGeneratorable lottoGeneratorable;
    private final LottoShuffleable lottoShuffleable;
    private final ConsoleInputView consoleInputView;
    private final ConsoleOutputView consoleOutputView;
    private final GameStatusChangeable gameStatusManager;

    public LottoGame(final LottoGeneratorable lottoGeneratorable,
        final LottoShuffleable lottoShuffleable, final GameStatusChangeable gameStatusManager,
        final ConsoleInputView consoleInputView, final ConsoleOutputView consoleOutputView) {
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

            consoleOutputView.lineSeparator();

            final Lotteries manualLotteries = prepareManualLotteries();

            consoleOutputView.lineSeparator();

            final LottoTicket lottoTicket = prepareLottoTicket(money, manualLotteries);

            final Lotto winningLotto = prepareWinningLotto();
            final BonusBall bonusBall = prepareBonusBall(winningLotto);

            consoleOutputView.lineSeparator();

            final String result = LottoResult.checkout(winningLotto, bonusBall, lottoTicket, money);
            consoleOutputView.print(result);

            gameStatusManager.end();
        } catch (Exception e) {
            consoleOutputView.error(e);
        }
    }

    private Money prepareMoney() {
        consoleOutputView.print("구입금액을 입력해 주세요.");

        return consoleInputView.inputMoney();
    }

    private LottoTicket prepareLottoTicket(final Money money, final Lotteries manualLotteries) {
        final LottoTicket lottoTicket = new LottoTicket(money, manualLotteries, lottoShuffleable);
        lottoTicket.publish();

        consoleOutputView.print(MessageFormat.format(
            "수동으로 {0}장, 자동으로 {1}개를 구매했습니다.",
            lottoTicket.sizeOfManualLotteries(), lottoTicket.sizeOfAutomationLotteries()));
        consoleOutputView.printLottoTicket(lottoTicket);
        consoleOutputView.lineSeparator();

        return lottoTicket;
    }

    private Lotto prepareWinningLotto() {
        consoleOutputView.print("지난 주 당첨 번호를 입력해 주세요.");

        return consoleInputView.inputWinningLotto(lottoGeneratorable);
    }

    private Lotteries prepareManualLotteries() {
        consoleOutputView.print("수동으로 구매할 로또 수를 입력해 주세요.");
        final int count = consoleInputView.inputManualLotteriesCount();

        if (NumberUtils.isZero(count)) {
            return Lotteries.EMPTY;
        }

        consoleOutputView.lineSeparator();
        consoleOutputView.print("수동으로 구매할 번호를 입력해 주세요.");

        return consoleInputView.inputManualLotteries(count, lottoGeneratorable);
    }

    private BonusBall prepareBonusBall(final Lotto winningLotto) {
        consoleOutputView.print("보너스 볼을 입력해 주세요.");

        return consoleInputView.inputBonusBall(winningLotto);
    }
}
