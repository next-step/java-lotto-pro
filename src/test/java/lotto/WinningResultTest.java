package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("WinningResult 클래스 테스트")
class WinningResultTest {

    @DisplayName("빈 WinningResult 생성")
    @Test
    void emptyWinningResult() {
        final WinningResult winningResult = new WinningResult();
        assertThat(winningResult.rateOfReturn()).isEqualTo(BigDecimal.ZERO);
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            assertThat(winningResult.find(lottoPrize)).isEqualTo(0);
        }
    }

    @DisplayName("LottoPrize 결과 데이터를 주입하여 당첨 횟수를 반환")
    @ParameterizedTest
    @CsvSource({
            "MISS, 1, 1",
            "THREE_MATCH, 1, 1",
            "FOUR_MATCH, 1, 1",
            "FIVE_MATCH, 1, 1",
            "SIX_MATCH, 1, 1",
            "SIX_MATCH, 10, 10",
            "SIX_MATCH, 100, 100"
    })
    void find(LottoPrize lottoPrize, int matchCount, int expected) {
        final Map<LottoPrize, Integer> map = new EnumMap<>(LottoPrize.class);
        map.put(lottoPrize, matchCount);
        final WinningResult winningResult = new WinningResult(map);
        assertThat(winningResult.find(lottoPrize)).isEqualTo(expected);
    }

    @DisplayName("LottoPrize 결과 데이터를 주입하여 당첨 수익율을 반환")
    @ParameterizedTest
    @CsvSource({
            "MISS, 1, 0.00",
            "THREE_MATCH, 1, 5.00",
            "FOUR_MATCH, 1, 50.00",
            "FIVE_MATCH, 1, 1500.00",
            "SIX_MATCH, 1, 2000000.00"
    })
    void rateOfReturn(LottoPrize lottoPrize, int matchCount, BigDecimal expected) {
        final Map<LottoPrize, Integer> map = new EnumMap<>(LottoPrize.class);
        map.put(lottoPrize, matchCount);
        final WinningResult winningResult = new WinningResult(map);
        assertThat(winningResult.rateOfReturn()).isEqualTo(expected);
    }
}