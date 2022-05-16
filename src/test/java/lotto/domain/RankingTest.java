package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @Test
    void 일치하는_번호_개수에_대한_랭킹() {
        assertThat(Ranking.findRank(6)).isEqualTo(Ranking.FIRST);
        assertThat(Ranking.findRank(5)).isEqualTo(Ranking.SECOND);
        assertThat(Ranking.findRank(4)).isEqualTo(Ranking.THIRD);
        assertThat(Ranking.findRank(3)).isEqualTo(Ranking.FOURTH);
        assertThat(Ranking.findRank(0)).isEqualTo(Ranking.NONE);
    }
}
