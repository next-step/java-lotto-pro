package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 우승 번호 테스트")
class WinningLottoNumbersTest {

    @DisplayName("문자로 입력한 로또 번호 예외 확인")
    @ParameterizedTest(name = "#{index} - \"{0}\"은 로또 번호로 생성될 수 없습니다.")
    @ValueSource(strings = {"1,2,3,4, 5", "a,b,c,1,2,3", "1,2,3,4,5,6,7", "1,2,3,4,5,-6"})
    void text_lotto_input_validity_verify(String input) {
        assertThatThrownBy(() -> new WinningLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 입력으로 생성 테스트")
    @ParameterizedTest(name = "#{index} - \"{0}\"은 로또 번호로 생성 가능합니다.")
    @ValueSource(strings = {"1,2,3,4,5,6", "1,2, 3,4,5, 6"})
    void create_input_lotto(String input) {
        assertThat(new WinningLottoNumbers(input)).isNotNull();
    }

    @DisplayName("로또 번호와 보너스 번호가 일치한 경우 오류")
    @Test
    void error_when_lotto_number_and_bonus_number_match() {
        assertThatThrownBy(() -> new WinningLottoNumbers("1,2,3,4,5,6", new LottoNumber(5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


}