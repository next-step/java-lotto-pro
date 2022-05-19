package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    public void 로또_당첨_결과_조회_테스트() {
        List<Ranking> rankings = Arrays.asList(Ranking.FIRST, Ranking.SECOND, Ranking.THIRD, Ranking.FOURTH);
        LottoResult result = new LottoResult(rankings);

        assertThat(result.getRankingList())
                .contains(Ranking.FIRST)
                .contains(Ranking.SECOND)
                .contains(Ranking.THIRD)
                .contains(Ranking.FOURTH);
    }

    @Test
    public void 로또_결과_조회_테스트() {
        List<Ranking> rankings = Arrays.asList(Ranking.FIRST, Ranking.SECOND, Ranking.THIRD, Ranking.FOURTH);
        LottoResult result = new LottoResult(rankings);

        assertThat(result.findRankings(6, false)).hasSize(1);
        assertThat(result.findRankings(5, true)).hasSize(1);
        assertThat(result.findRankings(5, false)).hasSize(1);
        assertThat(result.findRankings(4, false)).hasSize(1);
    }
}
