package lotto_auto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoNumberTest {
    @Test
    public void 로또번호_범위_체크() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber("100"))
                .withMessage(LottoNumber.NOT_RANGE_NUMBER);
    }

    @Test
    public void 로또번호_숫자_이외의_값_체크() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->  new LottoNumber("a"))
                .withMessage(LottoNumber.NOT_NUMBER);
    }

}
