package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("1과 45 사이의 값이 입력되면 로또 번호가 생성되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = { 1, 45 })
    void numberAllowRange(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber.equals(new LottoNumber(number))).isTrue();
    }

    @DisplayName("1과 45 밖의 값이 입력되면 에러가 발생되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = { 0, 46 })
    void numberNotAllowRange(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
