package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RankTest {

    @DisplayName("일치하는 숫자가 6개면 1등을 반환한다.")
    @Test
    void find_FIRST() {
        assertAll(
                () -> assertThat(Rank.findRank(6, true)).isEqualTo(Rank.FIRST),
                () -> assertThat(Rank.findRank(6, false)).isEqualTo(Rank.FIRST)
        );
    }

    @DisplayName("일치하는 숫자가 5개이고 보너스볼이 당첨되면 2등을 반환한다.")
    @Test
    void find_SECOND() {
        assertThat(Rank.findRank(5, true)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("일치하는 숫자가 5개이고 보너스볼이 미당첨되면 3등을 반환한다.")
    @Test
    void find_THIRD() {
        assertThat(Rank.findRank(5, false)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("일치하는 숫자가 4개면 4등을 반환한다.")
    @Test
    void find_FOURTH() {
        assertAll(
                () -> assertThat(Rank.findRank(4, true)).isEqualTo(Rank.FOURTH),
                () -> assertThat(Rank.findRank(4, false)).isEqualTo(Rank.FOURTH)
        );
    }

    @DisplayName("일치하는 숫자가 3개면 5등을 반환한다.")
    @Test
    void find_FIFTH() {
        assertAll(
                () -> assertThat(Rank.findRank(3, true)).isEqualTo(Rank.FIFTH),
                () -> assertThat(Rank.findRank(3, false)).isEqualTo(Rank.FIFTH)
        );
    }

    @DisplayName("일치하는 숫자가 3개 미만이면 MISS를 반환한다.")
    @Test
    void find_MISS() {
        assertAll(
                () -> assertThat(Rank.findRank(2, false)).isEqualTo(Rank.MISS),
                () -> assertThat(Rank.findRank(1, false)).isEqualTo(Rank.MISS),
                () -> assertThat(Rank.findRank(0, false)).isEqualTo(Rank.MISS)
        );
    }

}
