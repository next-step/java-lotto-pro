package lottoauto.util;

import lottoauto.service.InputNumberValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumberValidatorTest {

    @Test
    void 정상_문자_입력시() {
        String input = "1, 2, 4, 5, 7, 0";
        InputNumberValidator inputNumberValidator = new InputNumberValidator(input);

        assertThat(inputNumberValidator.toString()).contains("[1, 2, 4, 5, 7, 0]");
    }

    @Test
    void 비정상_문자_입력시() {
        String input = "1,2,3, 4, 5, 6";
        assertThatThrownBy(() -> new InputNumberValidator(input)).isInstanceOf(NumberFormatException.class);
    }


}