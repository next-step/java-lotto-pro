package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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
}
