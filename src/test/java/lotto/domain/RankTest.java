package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @DisplayName("일치하는 숫자가 6개면 1등을 반환한다.")
    @Test
    void find_FIRST() {
        assertThat(Rank.findRank(6)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("일치하는 숫자가 5개면 2등을 반환한다.")
    @Test
    void find_SECOND() {
        assertThat(Rank.findRank(5)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("일치하는 숫자가 4개면 3등을 반환한다.")
    @Test
    void find_THIRD() {
        assertThat(Rank.findRank(4)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("일치하는 숫자가 3개면 4등을 반환한다.")
    @Test
    void find_FOURTH() {
        assertThat(Rank.findRank(3)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("일치하는 숫자가 3개 미만이면 MISS를 반환한다.")
    @Test
    void find_MISS() {
        assertAll(
                () -> assertThat(Rank.findRank(2)).isEqualTo(Rank.MISS),
                () -> assertThat(Rank.findRank(1)).isEqualTo(Rank.MISS),
                () -> assertThat(Rank.findRank(0)).isEqualTo(Rank.MISS)
        );
    }

}
