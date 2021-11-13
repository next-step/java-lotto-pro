package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoCountTest {
    @ParameterizedTest
    @DisplayName("음수를 매개변수로 하거나, manualCount가 totalCount보다 클 경우 예외 발생")
    @CsvSource(value = {"0:-1", "-1:0", "1:0"}, delimiter = ':')
    void 객체_생성_시_유효성_검사(int manualCount, int totalCount) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new LottoCount(manualCount, totalCount)
        );
    }

    @Test
    @DisplayName("computeNumberOfLottoStatement 메서드 정상 작동 여부 테스트")
    void computeNumberOfLottoStatement() {
        LottoCount lottoCount = new LottoCount(2, 5);
        String numberOfLottoStatement = lottoCount.computeNumberOfLottoStatement();
        assertThat(numberOfLottoStatement).contains("2", "3");
    }

    @Test
    @DisplayName("동등성 검사")
    void equals() {
        LottoCount actual = new LottoCount(1, 5);
        LottoCount expected = new LottoCount(1, 5);
        assertThat(actual).isEqualTo(expected);
    }
}
