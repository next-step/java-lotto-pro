package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void 유효한_범위의_숫자생성(int validNumber) {
        LottoNumber number = new LottoNumber(validNumber);

        assertThat(number).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 유효하지_않은_범위의_숫자생성(int invalidNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumber(invalidNumber)
        ).withMessageContaining("유효한 범위의 숫자가 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 44})
    void 숫자_동등성_비교(int validNumber) {
        LottoNumber number = new LottoNumber(validNumber);

        assertThat(number).isEqualTo(new LottoNumber(validNumber));
    }
}
