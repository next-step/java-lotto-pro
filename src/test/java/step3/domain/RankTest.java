package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {
    @Test
    void 숫자가_일치한_갯수에_따른_등수_확인() {
        assertThat(Rank.of(6)).isEqualTo(Rank.FIRST);
        assertThat(Rank.of(5)).isEqualTo(Rank.THIRD);
        assertThat(Rank.of(4)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(3)).isEqualTo(Rank.FIFTH);
    }
}
