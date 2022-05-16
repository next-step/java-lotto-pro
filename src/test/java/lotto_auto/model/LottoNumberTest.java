package lotto_auto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoNumberTest {
    @Test
    public void 로또번호_범위_체크() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(100))
                .withMessage(LottoNumber.NOT_RANGE_NUMBER);
    }

}
