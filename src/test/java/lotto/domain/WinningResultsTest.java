package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("WinningResults 테스트")
class WinningResultsTest {

    private WinningResults winningResults;

    @BeforeEach
    void setUp() {
        winningResults = WinningResults.from(
                WinningResult.FIRST, WinningResult.FIRST, WinningResult.FIRST, WinningResult.THIRD,
                WinningResult.THIRD, WinningResult.FOURTH, WinningResult.FIFTH);
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {"FIRST:3", "THIRD:2", "FOURTH:1", "FIFTH:1"}, delimiter = ':')
    @DisplayName("요청 당첨에 해당되는 개수를 반환한다.")
    void getCount(WinningResult winningResult, int expected) {
        // when
        int count = winningResults.getCount(winningResult);

        // then
        assertThat(count).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익금을 반환한다.")
    void getProceeds() {
        // when
        long proceeds = winningResults.getProceeds();

        // then
        assertThat(proceeds).isEqualTo(6_003_055_000L);
    }
}
