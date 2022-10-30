package step3.domain.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.domain.statistics.Rank.valueOf;

class RankTest {

    @Test
    @DisplayName("당첨 번호 일치 개수에 따라 로또 당첨 유형을 리턴한다.")
    void findRankByMatchCount() {
        Rank rank = valueOf(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("5개 번호, 보너스 번호가 일치하는 경우 2등을 리턴한다.")
    void bonusTest() {
        Rank rank = valueOf(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 번호만 일치하는 경우 3등을 리턴한다.")
    void bonusTest3() {
        Rank rank = valueOf(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }
}
