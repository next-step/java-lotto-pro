package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    public void rank_test() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }
}