package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumberTest {

    @DisplayName("숫자가 1~45 사이의 숫자가 아니면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 46})
    void validate(int lottoNumber) {
        assertThatThrownBy(() -> LottoNumber.from(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 같으면 equals 비교 시 true를 반환한다.")
    @Test
    void equals() {
        LottoNumber lottoNumber = LottoNumber.from(5);

        assertThat(lottoNumber).isEqualTo(LottoNumber.from(5));
    }

}
