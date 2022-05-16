package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.Test;

class LottoWinningResultsTest {

    @Test
    void 수익률을_구할_수_있다() {
        List<LottoRank> ranks = new ArrayList<>();
        ranks.add(LottoRank.FIFTH);
        LottoWinningResults lottoWinningResults = LottoWinningResults.from(ranks);

        double profitRate = lottoWinningResults.profitRate(Money.from(14000));
        assertThat(String.format("%.2f", profitRate)).isEqualTo("0.36");
    }

    @Test
    void 우승상금을_구할수_있다() {
        List<LottoRank> ranks = new ArrayList<>();
        ranks.add(LottoRank.FIRST);
        ranks.add(LottoRank.SECOND);

        LottoWinningResults lottoWinningResults = LottoWinningResults.from(ranks);

        double prizedMoney = lottoWinningResults.prizedMoney();
        assertThat(prizedMoney).isEqualTo(2_030_000_000);
    }

    @Test
    void 등수의_개수를_구할수_있다() {
        List<LottoRank> ranks = new ArrayList<>();
        ranks.add(LottoRank.FIRST);
        ranks.add(LottoRank.SECOND);
        ranks.add(LottoRank.SECOND);

        LottoWinningResults lottoWinningResults = LottoWinningResults.from(ranks);

        int rankCount = lottoWinningResults.winningRankCount(LottoRank.SECOND);
        assertThat(rankCount).isEqualTo(2);
    }
}
