package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static lotto.util.InputValidator.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @Test
    @DisplayName("당첨번호 입력시 숫자포맷 오류 검사")
    public void validateNumberFormatTest() {
        assertThatThrownBy(
                () -> validateNumberFormat("1d")
        ).isInstanceOf(IllegalArgumentException.class)
         .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("1~45 사이의 숫자가 아닌 경우 테스트")
    public void validateLottoNumberRangeTest() {
        assertThatThrownBy(
                () -> validateLottoNumberRange(46)
        ).isInstanceOf(IllegalArgumentException.class)
         .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("6개의 로또 숫자가 아닌 경우 테스트")
    public void validateLottoNumberCountTest() {
        assertThatThrownBy(
                () -> validateLottoNumberCount(7)
        ).isInstanceOf(IllegalArgumentException.class)
         .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨번호 중복 테스트")
    public void validateDuplicateLottoNumberTest(){
        assertThatThrownBy(
                () -> validateDuplicateLottoNumber(Arrays.stream(new int[]{1,1,2,3,4,5}).boxed().collect(Collectors.toList()))
        ).isInstanceOf(IllegalArgumentException.class)
         .hasMessageContaining("[ERROR]");
    }
}