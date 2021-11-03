package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
class LottoNumberTest {

    @DisplayName("숫자가 1~45 사이의 숫자가 아니면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 46})
    void validate(int lottoNumber) {
        assertThatThrownBy(() -> LottoNumber.from(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
