package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> Rank.valueOf(2, false)
                                     .prize()).isInstanceOf(NoSuchElementException.class);
    }
}