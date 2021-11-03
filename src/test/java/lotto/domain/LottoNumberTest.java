package lotto.domain;

import lotto.exception.LottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {
            1, 45
    })
    @DisplayName("로또 번호 한개 생성 - 성공")
    public void lottoNumberTest_ok(int number) {
        assertThat(new LottoNumber(number))
                .isInstanceOf(LottoNumber.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {
            0, -1, 46
    })
    @DisplayName("로또 번호 한개 생성 - 실")
    public void lottoNumberTest_fail(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(LottoNumberRangeException.class);
    }

}