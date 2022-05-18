package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("보너스 번호에 대한 테스트")
class BonusNumberTest {

    @DisplayName("숫자 이외의 값을 전달해 보너스 넘버를 생성하면 예외가 발생해야 한다")
    @Test
    void bonus_number_exception_test2() {
        String 보너스_번호 = "a";

        assertThatThrownBy(() -> {
            new BonusNumber(보너스_번호);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_NUMBER_FORMAT.getMessage());
    }

    @DisplayName("로또번호인 1-45 이외의 보너스 넘버를 생성하면 예외가 발생해야 한다")
    @Test
    void bonus_number_exception_test3() {
        String 보너스_번호 = "90";

        assertThatThrownBy(() -> {
            new BonusNumber(보너스_번호);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_NUMBER_SIZE.getMessage());
    }

    @DisplayName("생성자에 인자를 넘기면 숫자형식으로 파싱되어 반환되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"11", "15", "31", "44"})
    void bonus_number_success(String 보너스_번호) {

        BonusNumber bonusNumber = new BonusNumber(보너스_번호);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(Integer.parseInt(보너스_번호));
    }
}
