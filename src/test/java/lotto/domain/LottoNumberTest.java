package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @DisplayName("로또 번호는 1과 45 사이여야 한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void lotto_number_exception_test(int index) {
        assertThatThrownBy(() -> LottoNumber.get(index))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1과 45 사이여야 합니다.");
    }
}
