package step3.view;

import java.util.StringJoiner;
import step3.domain.Lotto;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.enums.Prizes;

public final class LottoResult {

    private LottoResult() {
    }

    public static String checkout(final Lotto winningLotto, final LottoTicket lottoTicket, final Money money) {
        final StringJoiner result = new StringJoiner(System.lineSeparator());

        result.add("당첨 통계");
        result.add("---------");

        final Prizes prizes = lottoTicket.toWinningPrizes(winningLotto);

        result.add(prizes.getResults());
        result.add(prizes.averageYield(money));

        return result.toString();
    }
}
