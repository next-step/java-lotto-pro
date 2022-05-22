package lotto.domain;

import lotto.exception.LottoNumberRangeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @Test
    @DisplayName("로또번호 정상적으로 생성")
    void 로또번호_생성_정상() {
        Assertions.assertThat(new LottoNumber(10).toLottoNumberDTO().getLottoNumber())
            .isEqualTo(10);
    }

    @ParameterizedTest(name = "로또번호 : {0}")
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("로또번호가 1 ~ 45가 아닐 경우 예외 발생")
    void 로또번호_생성_예외(int invalidLottoNumber) {
        Assertions.assertThatThrownBy(() -> new LottoNumber(invalidLottoNumber))
            .isInstanceOf(LottoNumberRangeException.class);
    }
}