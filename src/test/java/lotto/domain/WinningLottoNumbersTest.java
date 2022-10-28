package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoNumbersTest {

    @DisplayName("문자로 입력한 로또 번호 예외 확인")
    @ParameterizedTest(name = "#{index} - \"{0}\"은 로또 번호로 생성될 수 없습니다.")
    @ValueSource(strings = {"1,2,3,4, 5", "a,b,c,1,2,3", "1,2,3,4,5,6,7"})
    void text_lotto_input_validity_verify(String input) {
        Assertions.assertThatThrownBy(() -> new WinningLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}