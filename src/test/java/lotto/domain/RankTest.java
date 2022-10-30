package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankTest {
    @Test
    void 맞힌수와_보너스번호맞춘여부로_등수를_구한다() {
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
    }
}