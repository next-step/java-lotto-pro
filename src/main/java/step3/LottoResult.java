package step3;

import step3.domain.Lotto;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.enums.Prizes;
import step3.view.ConsoleOutputView;

public class LottoResult {

    public void check(final Lotto winningLotto, final LottoTicket lottoTicket, final Money money) {
        ConsoleOutputView.print("당첨 통계");
        ConsoleOutputView.print("---------");
        ConsoleOutputView.lineSeparator();

        final Prizes prizes = lottoTicket.check(winningLotto);

        ConsoleOutputView.print(prizes.getResults());
        ConsoleOutputView.print(prizes.averageYield(money));
    }
}
