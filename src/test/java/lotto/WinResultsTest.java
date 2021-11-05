package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("WinResults 테스트")
class WinResultsTest {

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource(value = {"6:2", "5:1", "4:1", "3:0"}, delimiter = ':')
    @DisplayName("요청 당첨에 해당되는 개수를 반환한다.")
    void getCount(int matchedCount, int expected) {
        // given
        WinResults winResults = WinResults.from(
                WinResult.SIX_MATCHED, WinResult.SIX_MATCHED, WinResult.FIVE_MATCHED, WinResult.FOUR_MATCHED);

        // when
        int count = winResults.getCount(matchedCount);

        // then
        assertThat(count).isEqualTo(expected);
    }
}
