package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoStatus별 당첨 금액과 수익률을 관리하는 클래스 테스트")
class WinStatsTest {

    @ParameterizedTest
    @CsvSource(value = { "20:1505.00", "14:2150.00", "100:301.00", "50:602.00" }, delimiter = ':')
    void 당첨_계산_검증(int quantity, String expected) {
        WinStats winStats = new WinStats(quantity);

        winStats.accumulate(LottoStatus.FOURTH_PLACE);
        winStats.accumulate(LottoStatus.FOURTH_PLACE);
        winStats.accumulate(LottoStatus.SECOND_PLACE);
        winStats.calculate();

        Map<LottoStatus, Long> printData = winStats.countsByLottoStatus();

        assertAll(
                () -> assertEquals(2L, printData.get(LottoStatus.FOURTH_PLACE)),
                () -> assertEquals(1L, printData.get(LottoStatus.SECOND_PLACE)),
                () -> assertEquals(expected, winStats.getProfitRate())
        );
    }
}
