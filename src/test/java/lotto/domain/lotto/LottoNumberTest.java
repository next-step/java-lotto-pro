package lotto.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest(name = "{index} | {displayName} | input = {0}")
    @ValueSource(ints = {-1, 0, 46})
    @DisplayName("1 ~ 45 이외의 숫자가 들어오면 IllegalArgumentException을 던진다.")
    void lottoNumberException1(int input) {
        Assertions.assertThatThrownBy(() -> LottoNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
