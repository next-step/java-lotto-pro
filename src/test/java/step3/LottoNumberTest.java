package step3;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LottoNumber;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 범위 체크 기능 테스트")
    void lottoInRange() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumber(100))
            .withMessage(LottoNumber.ERROR_RANGE_NUMBER);
    }

}
