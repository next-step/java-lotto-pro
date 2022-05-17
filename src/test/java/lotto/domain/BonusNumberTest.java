package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("보너스 번호에 대한 테스트")
class BonusNumberTest {
    private WinningNumbers 이전_당첨_번호;

    @BeforeEach
    void setUp() {
        이전_당첨_번호 = new WinningNumbers("1,2,3,4,5,6");
    }

    @DisplayName("이전 당첨번호와 중복된 보너스 넘버를 생성하면 예외가 발생해야 한다")
    @Test
    void bonus_number_exception_test() {
        String 보너스_번호 = "5";

        assertThatThrownBy(() -> {
            new BonusNumber(보너스_번호, 이전_당첨_번호);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.ALREADY_EXISTS_WINNINGS_NUMBER.getMessage());
    }

    @DisplayName("숫자 이외의 값을 전달해 보너스 넘버를 생성하면 예외가 발생해야 한다")
    @Test
    void bonus_number_exception_test2() {
        String 보너스_번호 = "a";

        assertThatThrownBy(() -> {
            new BonusNumber(보너스_번호, 이전_당첨_번호);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_NUMBER_FORMAT.getMessage());
    }

    @DisplayName("로또번호인 1-45 이외의 보너스 넘버를 생성하면 예외가 발생해야 한다")
    @Test
    void bonus_number_exception_test3() {
        String 보너스_번호 = "90";

        assertThatThrownBy(() -> {
            new BonusNumber(보너스_번호, 이전_당첨_번호);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_NUMBER_SIZE.getMessage());
    }

    @DisplayName("생성자에 인자를 넘기면 숫자형식으로 파싱되어 반환되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"11", "15" , "31" , "44"})
    void bonus_number_success(String 보너스_번호) {

        BonusNumber bonusNumber = new BonusNumber(보너스_번호, 이전_당첨_번호);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(Integer.parseInt(보너스_번호));
    }
}
