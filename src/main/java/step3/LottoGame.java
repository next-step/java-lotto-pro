package step3;

import step3.domain.Lotto;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.view.ConsoleInputView;
import step3.view.ConsoleOutputView;

public class LottoGame {

    private final ConsoleInputView consoleInputView;
    private final ConsoleOutputView consoleOutputView;
    private final LottoResult lottoResult;

    public LottoGame(final ConsoleInputView consoleInputView, final ConsoleOutputView consoleOutputView,
        final LottoResult lottoResult) {
        this.consoleInputView = consoleInputView;
        this.consoleOutputView = consoleOutputView;
        this.lottoResult = lottoResult;
    }

    public void start() {
        try {
            final Money money = prepareMoney();
            final LottoTicket lottoTicket = prepareLottoTicket(money);

            final Lotto winningLotto = prepareWinningLotto();
            consoleOutputView.lineSeparator();

            final String result = lottoResult.checkout(winningLotto, lottoTicket, money);
            consoleOutputView.print(result);
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

    private LottoTicket prepareLottoTicket(Money money) {
        final LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.publish(money);

        consoleOutputView.printLottoTicket(lottoTicket);
        consoleOutputView.lineSeparator();

        return lottoTicket;
    }

    private Lotto prepareWinningLotto() {
        consoleOutputView.print("지난 주 당첨 번호를 입력해 주세요.");

        return consoleInputView.inputWinningLotto();
    }
}
