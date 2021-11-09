package step3;

import java.util.StringJoiner;
import step3.domain.Lotto;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.enums.Prizes;

public class LottoResult {

    public String checkout(final Lotto winningLotto, final LottoTicket lottoTicket, final Money money) {
        final StringJoiner result = new StringJoiner(System.lineSeparator());

        result.add("당첨 통계");
        result.add("---------");

        final Prizes prizes = lottoTicket.check(winningLotto);

        result.add(prizes.getResults());
        result.add(prizes.averageYield(money));

        return result.toString();
    }
}
