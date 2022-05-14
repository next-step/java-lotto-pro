package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 숫자를 필드에 셋팅하고 LottoNumber 객체를 생성한다.")
    @ValueSource(ints = {1, 10, 25, 45})
    void LottoNumber_(int input) {
        assertThat(LottoNumber.of(input))
                .isExactlyInstanceOf(LottoNumber.class)
                .hasFieldOrPropertyWithValue("number", input);
    }
}