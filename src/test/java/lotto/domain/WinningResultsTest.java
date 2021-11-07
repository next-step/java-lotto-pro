package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("WinningResults 테스트")
class WinningResultsTest {

    @Test
    @DisplayName("수익금을 반환한다.")
    void getProceeds() {
        // given
        WinningResults winningResults = WinningResults.from(
                WinningResult.FIRST, WinningResult.FIRST, WinningResult.FIRST, WinningResult.THIRD,
                WinningResult.THIRD, WinningResult.FOURTH, WinningResult.FIFTH);

        // when
        long proceeds = winningResults.getProceeds();

        // then
        assertThat(proceeds).isEqualTo(6_003_055_000L);
    }
}
