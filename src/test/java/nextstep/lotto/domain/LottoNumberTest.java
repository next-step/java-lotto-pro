package nextstep.lotto.domain;

import nextstep.lotto.exception.LottoRuntimeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("유효한 로또 넘버 생성자 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 8, 9})
    public void constructorTest(Integer given) {

        // when
        LottoNumber lottoNumber = new LottoNumber(given);

        // then
        Assertions.assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("유효하지 않는 로또 넘버 생성자 테스트")
    @ParameterizedTest
    @ValueSource(ints = {100, -1, 0})
    public void constructorExceptionTest(Integer given) {
        Assertions.assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(given);
        }).isInstanceOf(LottoRuntimeException.class);
    }
}
