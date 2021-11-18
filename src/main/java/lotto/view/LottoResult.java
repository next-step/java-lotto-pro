package lotto.view;

import java.util.StringJoiner;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Ranks;

public final class LottoResult {

    private LottoResult() {
    }

    public static String checkout(final Lotto winningLotto, final LottoTicket lottoTicket, final Money money) {
        final StringJoiner result = new StringJoiner(System.lineSeparator());

        result.add("당첨 통계");
        result.add("---------");

        final Ranks ranks = lottoTicket.toWinningRanks(winningLotto);

        result.add(ranks.getResults());
        result.add(ranks.averageYield(money));

        return result.toString();
    }
}
