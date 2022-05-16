package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @Test
    void 일치하는_번호_개수에_대한_랭킹() {
        assertThat(Ranking.findRank(6, false)).isEqualTo(Ranking.FIRST);
        assertThat(Ranking.findRank(5, true)).isEqualTo(Ranking.SECOND);
        assertThat(Ranking.findRank(5, false)).isEqualTo(Ranking.THIRD);
        assertThat(Ranking.findRank(4, false)).isEqualTo(Ranking.FOURTH);
        assertThat(Ranking.findRank(3, false)).isEqualTo(Ranking.FIFTH);
        assertThat(Ranking.findRank(0, false)).isEqualTo(Ranking.NONE);
    }
}
