package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 50, 23635})
    @DisplayName("범위(1~45) 외 로또번호 생성 시 IllegalArgumentException 예외 발생")
    void 범위_외_로또번호_생성(int data) {
        assertThatThrownBy(() -> new LottoNumber(data))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("같은 번호로 생성한 LottoNumber 객체 비교")
    void 로또_번호_비교(int data) {
        LottoNumber number1 = new LottoNumber(data);
        LottoNumber number2 = new LottoNumber(data);
        assertThat(number1.compareTo(number2)).isEqualTo(0);
    }
}
