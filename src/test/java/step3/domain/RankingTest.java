package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankingTest {
    @Test
    void 당첨순위_찾기() {
        assertThat(Ranking.findRanking(6, false)).isEqualTo(Ranking.FIRST);
        assertThat(Ranking.findRanking(5, true)).isEqualTo(Ranking.SECOND);
        assertThat(Ranking.findRanking(5, false)).isEqualTo(Ranking.THIRD);
        assertThat(Ranking.findRanking(2, false)).isEqualTo(Ranking.NONE);
    }
}