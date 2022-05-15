package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    @DisplayName("로또 숫자는 1 ~ 45의 숫자만 가진다.")
    void isNotNegativeLottoNumber(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));

    }
}
