package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {
    @Test
    void 숫자가_일치한_갯수와_보너스번호_일치여부에_따른_등수_확인() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.of(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.of(2, false)).isEqualTo(Rank.MISS);
        assertThat(Rank.of(2, true)).isEqualTo(Rank.MISS);
    }
}
