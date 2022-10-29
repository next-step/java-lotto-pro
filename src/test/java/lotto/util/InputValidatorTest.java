package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.util.InputValidator.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @Test
    @DisplayName("당첨번호 입력시 숫자포맷 오류 검사")
    public void validateNumberFormatTest(){
        assertThatThrownBy(
            () -> validateNumberFormat("1d")
        ).isInstanceOf(IllegalArgumentException.class)
         .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("1~45 사이의 숫자가 아닌 경우 테스트")
    public void validateLottoNumberTest(){
        assertThatThrownBy(
            () -> validateLottoNumber(46)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("6개의 로또 숫자가 아닌 경우 검사")
    public void validateLottoNumberCountTest(){
        assertThatThrownBy(
            () -> validateLottoNumberCount(7)
        ).isInstanceOf(IllegalArgumentException.class)
         .hasMessageContaining("[ERROR]");
    }
}