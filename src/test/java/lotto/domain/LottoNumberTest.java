package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 단일 숫자 테스트")
class LottoNumberTest {

    @DisplayName("로또 예외 확인")
    @ParameterizedTest(name = "#{index}. {0}은 로또 번호를 생성할 수 없다.")
    @ValueSource(ints = {0, 46})
    public void 로또_생성(int value) {
        assertThatThrownBy(() -> new LottoNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}