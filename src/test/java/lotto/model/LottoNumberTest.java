package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @DisplayName("1 ~ 45 숫자가 아닌 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3"})
    void invalidLottoNumberTest(String input) {
        assertThatThrownBy(() -> {
            new LottoNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}