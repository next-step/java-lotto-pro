package step3;

import step3.domain.Lotto;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.view.ConsoleInputView;
import step3.view.ConsoleOutputView;

public class LottoGame {

    private final LottoResult lottoResult;

    public LottoGame(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public void start() {
        final Money money = prepareMoney();
        final LottoTicket lottoTicket = prepareLottoTicket(money);

        final Lotto winningLotto = ConsoleInputView.inputWinningLotto();
        ConsoleOutputView.lineSeparator();

        lottoResult.check(winningLotto, lottoTicket, money);
    }

    private Money prepareMoney() {
        final Money money = ConsoleInputView.inputMoney();

        ConsoleOutputView.printMoney(money);

        return money;
    }

    private LottoTicket prepareLottoTicket(Money money) {
        final LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.publish(money);

        ConsoleOutputView.printLottoTicket(lottoTicket);
        ConsoleOutputView.lineSeparator();

        return lottoTicket;
    }
}
