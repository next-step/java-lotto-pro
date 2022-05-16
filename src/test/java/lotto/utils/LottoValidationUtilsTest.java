package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoValidationUtilsTest {

    @Test
    void 로또번호는_1에서_45사이의_숫자여만_합니다() {
        LottoValidationUtils.validateNumberRange(1);
        LottoValidationUtils.validateNumberRange(45);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoValidationUtils.validateNumberRange(0));
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoValidationUtils.validateNumberRange(46));
    }

}