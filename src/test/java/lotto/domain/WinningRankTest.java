package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningRankTest {
    @Test
    @DisplayName("당첨 결과를 반환한다")
    void return_winning_rank() {
        assertAll(
                () -> assertThat(WinningRank.match(5, true)).isEqualTo(WinningRank.SECOND),
                () -> assertThat(WinningRank.match(5, false)).isEqualTo(WinningRank.THIRD)
        );
    }
}
