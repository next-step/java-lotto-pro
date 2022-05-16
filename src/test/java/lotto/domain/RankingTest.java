package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @Test
    public void 일치하는_번호_개수에_대한_랭킹() {
        assertThat(Ranking.findRank(6, false)).isEqualTo(Ranking.FIRST);
        assertThat(Ranking.findRank(5, true)).isEqualTo(Ranking.SECOND);
        assertThat(Ranking.findRank(5, false)).isEqualTo(Ranking.THIRD);
        assertThat(Ranking.findRank(4, false)).isEqualTo(Ranking.FOURTH);
        assertThat(Ranking.findRank(3, false)).isEqualTo(Ranking.FIFTH);
        assertThat(Ranking.findRank(0, false)).isEqualTo(Ranking.NONE);
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3, 4 })
    public void 보너스_번호_4등_이하_의미_없음(int matchingCount) {
        Ranking rankingWithBonus = Ranking.findRank(matchingCount, true);
        Ranking rankingWithoutBonus = Ranking.findRank(matchingCount, false);
        assertThat(rankingWithBonus).isEqualTo(rankingWithoutBonus);
    }

    @Test
    public void 보너스_여부로_2등_3등_비교() {
        Ranking actual = Ranking.findRank(5, true);
        assertThat(actual).isEqualTo(Ranking.SECOND);

        actual = Ranking.findRank(5, false);
        assertThat(actual).isEqualTo(Ranking.THIRD);
    }
}
