package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankingTest {
    @Test
    void 당첨순위_찾기() {
        assertThat(Ranking.findRanking(3)).isEqualTo(Ranking.FIFTH);
    }
}