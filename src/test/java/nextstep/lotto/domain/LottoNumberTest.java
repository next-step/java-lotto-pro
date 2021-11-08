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

    @DisplayName("유효한 로또 넘버 생성자 테스트")
    @ParameterizedTest
    @ValueSource(ints = {10, -1, 0})
    public void constructorExceptionTest(Integer given) {
        Assertions.assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(given);
            System.out.println(lottoNumber);
        }).isInstanceOf(LottoRuntimeException.class);
    }
}
