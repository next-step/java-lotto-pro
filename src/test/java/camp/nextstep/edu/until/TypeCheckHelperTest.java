package camp.nextstep.edu.until;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TypeCheckHelperTest {

    @Test
    void 문자열_숫자_체크_정상동작_확인() {
        String numberString = "123";
        String minusNumberString = "-123";
        String notNumberString = "a123!";

        assertThat(TypeCheckHelper.isPossibleStringToInteger(numberString)).isTrue();
        assertThat(TypeCheckHelper.isPossibleStringToInteger(minusNumberString)).isTrue();
        assertThat(TypeCheckHelper.isPossibleStringToInteger(notNumberString)).isFalse();
    }
}
