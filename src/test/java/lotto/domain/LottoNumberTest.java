package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호는 1~45 안에 속하지 않으면 예외를 발생시킨다.")
    void 로또숫자_범위_예외_테스트(int value) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoNumber.create(value)
        );
    }
}
