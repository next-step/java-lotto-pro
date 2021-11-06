package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("WinResults 테스트")
class WinResultsTest {

    private WinResults winResults;

    @BeforeEach
    void setUp() {
        winResults = WinResults.from(
                WinResult.FIRST, WinResult.FIRST, WinResult.FIRST, WinResult.THIRD,
                WinResult.THIRD, WinResult.FOURTH, WinResult.FIFTH);
    }

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {"6:3", "5:2", "4:1", "3:1"}, delimiter = ':')
    @DisplayName("요청 당첨에 해당되는 개수를 반환한다.")
    void getCount(int matchedCount, int expected) {
        // when
        int count = winResults.getCount(matchedCount);

        // then
        assertThat(count).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익금을 반환한다.")
    void getProceeds() {
        // when
        long proceeds = winResults.getProceeds();

        // then
        assertThat(proceeds).isEqualTo(6_003_055_000L);
    }
}
