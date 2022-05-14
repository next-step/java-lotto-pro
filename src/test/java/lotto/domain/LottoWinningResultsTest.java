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
        ranks.add(LottoRank.FOURTH);
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
        assertThat(prizedMoney).isEqualTo(2_001_500_000);
    }
}
