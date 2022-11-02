package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 우승 번호 테스트")
class WinningLottoNumbersTest {

    @DisplayName("문자로 입력한 로또 번호 예외 확인")
    @ParameterizedTest(name = "#{index} - 당첨 로또 번호 \"{0}\"과 보너스번호 {1}은 로또 번호가 될 수 없다.")
    @MethodSource("invalid_lotto_tickets")
    void text_lotto_input_validity_verify(String lottoNumbers, int bonusNumber) {
        assertThatThrownBy(() -> new WinningLottoNumbers(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> invalid_lotto_tickets() {
        return Stream.of(
                Arguments.of("1,2,3,4,5", 9),
                Arguments.of("1,2,3,4,-5", 9),
                Arguments.of("1,3,3,4,a", 3),
                Arguments.of("1,2,-22,!,5", 33),
                Arguments.of("1,2,3,4,5,6,7", 45)
        );
    }

    @DisplayName("로또 입력으로 생성 테스트")
    @ParameterizedTest(name = "#{index} - 당첨 로또 번호 \"{0}\"과 보너스번호 {1}은 로또 번호로 생성 가능하다.")
    @MethodSource("lotto_tickets")
    void create_input_lotto(String lottoNumbers, int bonusNumber) {
        assertThat(new WinningLottoNumbers(lottoNumbers, bonusNumber)).isNotNull();
    }

    public static Stream<Arguments> lotto_tickets() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", 7),
                Arguments.of("9, 10, 23, 25, 33, 44", 45),
                Arguments.of("1,2,3,4,22, 6", 8)
        );
    }

    @DisplayName("로또 번호와 보너스 번호가 일치한 경우 오류")
    @Test
    void error_when_lotto_number_and_bonus_number_match() {
        assertThatThrownBy(() -> new WinningLottoNumbers("1,2,3,4,5,6", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

}