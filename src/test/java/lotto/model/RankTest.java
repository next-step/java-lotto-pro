package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    void 오등() {
        assertThat(Rank.valueOf(3, false)
                       .prize()).isEqualTo(5000);
    }

    @Test
    void 사등() {
        assertThat(Rank.valueOf(4, false)
                       .prize()).isEqualTo(50000);
    }

    @Test
    void 삼등() {
        assertThat(Rank.valueOf(5, false)
                       .prize()).isEqualTo(1500000);
    }

    @Test
    void 이등() {
        assertThat(Rank.valueOf(5, true)
                       .prize()).isEqualTo(30000000);
    }

    @Test
    void 일등() {
        assertThat(Rank.valueOf(6, false)
                       .prize()).isEqualTo(2000000000);
    }

    @Test
    void 예외() {
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.MISS);
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.MISS);
    }
}