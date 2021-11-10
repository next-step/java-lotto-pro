package lotto.enums;

import lotto.domain.MatchResult;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {

    @Test
    void rank_1등() {
        MatchResult matchResult = MatchResult.from(6, false);
        assertThat(Ranking.findCorrect(matchResult)).isEqualTo(Ranking.FIRST);
    }

    @Test
    void rank_2등_보너스() {
        MatchResult matchResult = MatchResult.from(5, true);
        assertThat(Ranking.findCorrect(matchResult)).isEqualTo(Ranking.SECOND_BONUS);
    }

    @Test
    void rank_2등() {
        MatchResult matchResult = MatchResult.from(5, false);
        assertThat(Ranking.findCorrect(matchResult)).isEqualTo(Ranking.SECOND);
    }

    @Test
    void rank_3등() {
        MatchResult matchResult = MatchResult.from(4, false);
        assertThat(Ranking.findCorrect(matchResult)).isEqualTo(Ranking.THIRD);
    }

    @Test
    void rank_4등() {
        MatchResult matchResult = MatchResult.from(3, false);
        assertThat(Ranking.findCorrect(matchResult)).isEqualTo(Ranking.FORTH);
    }
}
