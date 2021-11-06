package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputViewTest {

    @ParameterizedTest
    @DisplayName("구입 금액 입력값 검증")
    @ValueSource(strings = "15000")
    public void parseInputStringToInteger(String inputString) {

        validateNumberFormat(inputString);

        int actual = Integer.parseInt(inputString);

        assertThat(actual).isEqualTo(15000);
    }

    @ParameterizedTest
    @DisplayName("구입 금액 입력값 검증_오류")
    @ValueSource(strings = "가")
    public void parseInputStringToIntegerError(String inputString) {
        assertThatThrownBy(() -> {
            validateNumberFormat(inputString);

            assertThat(Integer.parseInt(inputString)).isEqualTo(15000);
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("당첨번호 입력값 검증")
    @ValueSource(strings = "1,2,3,4,5,6")
    public void parseInputStringToNumberList(String inputString) {
        for (String number : inputString.split(",")) {
            validateNumberFormat(number);
        }
    }

    @ParameterizedTest
    @DisplayName("당첨번호 입력값 검증_오류")
    @ValueSource(strings = "1,2,3,4,5,6")
    public void parseInputStringToNumberListError(String inputString) {
        assertThatThrownBy(() -> {
            for (String number : inputString.split(",")) {
                validateNumberFormat(number);
            }
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("[ERROR]");
    }

    public void validateNumberFormat(String inputString) {
        boolean matches = inputString.matches("^[0-9]+$");
        if (!matches) {
            System.out.println("[ERROR] 숫자 형식이 아닙니다.");
            throw new NumberFormatException("[ERROR] 숫자 형식이 아닙니다.");
        }
    }

}