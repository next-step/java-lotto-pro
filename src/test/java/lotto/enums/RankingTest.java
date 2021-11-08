package lotto.enums;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @Test
    void rank_4등() {
        assertThat(Ranking.findCorrect(3)).isEqualTo(Ranking.FORTH);
    }

    @Test
    void rank_3등() {
        assertThat(Ranking.findCorrect(4)).isEqualTo(Ranking.THIRD);
    }

    @Test
    void rank_2등() {
        assertThat(Ranking.findCorrect(5)).isEqualTo(Ranking.SECOND);
    }

    @Test
    void rank_1등() {
        assertThat(Ranking.findCorrect(6)).isEqualTo(Ranking.FIRST);
    }
}
